package com.tuf2000.modbus.register;

import com.tuf2000.modbus.logics.BCD;
import com.tuf2000.modbus.logics.ConverterFactory;
import com.tuf2000.modbus.logics.IBaseType;
import com.tuf2000.modbus.utils.RegisterLoader;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class RegisterService {

    public List<Register> getRegister() throws IOException {
        return RegisterLoader.loadRegisters(); }
    public List<Map<String, String>> calculateByInputData(String input) throws IOException {
        HashMap<String, Integer> dict = parseInput(input);
        List<Register> allRegisters = RegisterLoader.loadRegisters();
        return calculateRegistersValues(dict, allRegisters);
    }

    @NotNull
    private static HashMap<String, Integer> parseInput(String input) {
        String[] lines = input.split("\\r?\\n");
        HashMap<String, Integer> dict = new HashMap<> ();
        for (int i = 1; i < lines.length; i++) {
            String[] keyValue = lines[i].strip().split(":");
            if (keyValue.length != 2) {
                continue;
            }
            try {
                String key = String.format("%04d", Integer.parseInt(keyValue[0]));
                int value = Integer.parseInt(keyValue[1]);
                dict.put(key, value);
            } catch (Exception ignored) {
            }
        }
        return dict;
    }

    @NotNull
    private static List<Map<String, String>> calculateRegistersValues(HashMap<String, Integer> input, List<Register> allRegisters) {
        List<Map<String, String>> resultList = new ArrayList<>();
        for (Register register : allRegisters) {
            String[] associatedList=register.getASSOCIATED();
            IBaseType converter= ConverterFactory.createConverter(register.getFORMAT());
            assert converter != null;
            assert associatedList != null && associatedList.length > 0;
            Integer reg1= input.get(associatedList[0]);
            Integer reg2, reg3;
            String registerValue = "No Input";
            try {
                switch (associatedList.length) {
                    case 1 -> {
                        if (reg1 != null) {
                            registerValue = converter.convert(reg1);
                        }
                    }
                    case 2 -> {
                        reg2 = input.get(associatedList[1]);
                        if (reg1 != null && reg2 != null) {
                            registerValue = converter.convert(reg1, reg2);
                        }
                    }
                    case 3 -> {
                        reg2 = input.get(associatedList[1]);
                        reg3 = input.get(associatedList[2]);
                        if (reg1 != null && reg2 != null && reg3 != null) {
                            registerValue = ((BCD) converter).convert(reg1, reg2, reg3);
                        }
                    }
                }
            } catch (Exception e) {
                registerValue="Failed to calculate";
            }
            resultList.add(Map.of(register.getREGISTER_NAME()+" "+register.getVARIABLE_NAME(),registerValue));
        }
        return resultList;
    }
}
