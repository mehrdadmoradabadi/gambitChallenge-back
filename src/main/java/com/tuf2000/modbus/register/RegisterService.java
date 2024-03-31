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
        return resultList;
    }
}
