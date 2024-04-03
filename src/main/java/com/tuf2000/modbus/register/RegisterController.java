package com.tuf2000.modbus.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("api/v1/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @GetMapping("/all")
    public List<Register> getRegister() throws IOException {
        return registerService.getRegister();
    }

    @PostMapping(consumes = {"text/plain"},path = "/")
    public List<Map<String, String>> findRegister(@RequestBody String inputData) throws IOException {
        String[] lines = inputData.split("\\r?\\n");
        HashMap<String, Integer> dict = new HashMap<String, Integer> ();
        for (int i = 1; i < lines.length; i++) {
            String[] keyValue = lines[i].strip().split(":");
            String key = String.format("%04d", Integer.parseInt(keyValue[0]));
            int value = Integer.parseInt(keyValue[1]);
            dict.put(key, value);}

        return registerService.findByInputData(dict);
    }
}
