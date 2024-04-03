package com.tuf2000.modbus.register;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RegisterServiceTest {

    @Test
    public void testFindByInputData() throws IOException {
        HashMap<String, Integer> input = new HashMap<>();
        input.put("0001", 7579);
        input.put("0002", 48988);
        input.put("0003", 5064);
        input.put("0004", 48142);
        RegisterService registerService = new RegisterService();

        List<Map<String, String>> result = registerService.findByInputData(input);

        assertEquals(46, result.size());
        Map<String, String> resultMap = result.get(0);
        assertEquals("-0.85982674", resultMap.get("0001-0002 Flow Rate"));
        resultMap = result.get(1);
        assertEquals("-0.008671708", resultMap.get("0003-0004 Energy Flow Rate"));

    }

    @Test
    void getRegister() throws IOException {
        RegisterService registerService = new RegisterService();
        List<Register> result = registerService.getRegister();
        assertEquals(46, result.size());
    }
}