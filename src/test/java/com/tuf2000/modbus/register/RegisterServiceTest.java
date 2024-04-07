package com.tuf2000.modbus.register;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RegisterServiceTest {

    @Test
    public void testFindByInputData() throws IOException {
        String input = "2017-01-11 19:12 \r\n0001:7579\r\n0002:48988\r\n0003:5064\r\n0004:48142\r\n";
        RegisterService registerService = new RegisterService();
        List<Map<String, String>> result = registerService.calculateByInputData(input);
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