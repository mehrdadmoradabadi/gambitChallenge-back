package com.tuf2000.modbus.register;

import com.tuf2000.modbus.logics.ConverterFactory;
import com.tuf2000.modbus.logics.IBaseType;
import com.tuf2000.modbus.logics.INTEGER;
import com.tuf2000.modbus.utils.RegisterLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class RegisterService {

    public List<Register> getRegister() throws IOException {
        return RegisterLoader.loadRegisters(); }
    public List<Map<String, String>> findByInputData(HashMap<String, Integer> input) throws IOException {
        List<Register> allRegisters = RegisterLoader.loadRegisters();
        List<Map<String, String>> resultList = new ArrayList<>();
        for (Register register : allRegisters) {
            String[] associatedList=register.getASSOCIATED();
            IBaseType converter= ConverterFactory.createConverter(register.getFORMAT());
            Integer reg1=0;
            Integer reg2=0;
            Integer reg3=0;

            try {
            switch (associatedList.length) {
                case 1 -> {
                    reg1 = input.get(associatedList[0]);
                    assert converter != null;
                    resultList.add(Map.of(register.getREGISTER_NAME()+" "+register.getVARIABLE_NAME(),converter.convert(reg1)));
                }
                case 2 -> {
                    reg1 = input.get(associatedList[0]);
                    reg2 = input.get(associatedList[1]);
                    assert converter != null;
                    resultList.add(Map.of(register.getREGISTER_NAME()+" "+register.getVARIABLE_NAME(),converter.convert(reg1, reg2)));
                }
                case 3 -> {
                    reg1 = input.get(associatedList[0]);
                    reg2 = input.get(associatedList[1]);
                    reg3 = input.get(associatedList[2]);
                    assert converter != null;
                    resultList.add(Map.of(register.getREGISTER_NAME()+" "+register.getVARIABLE_NAME(),((INTEGER) converter).convert(reg1, reg2, reg3)));

                }
            }} catch (Exception e) {
                resultList.add(Map.of(register.getREGISTER_NAME(), "Not Implemented"));
            }

        }
        return resultList;
    }
}
