package com.tuf2000.modbus.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("api/v1/register")
public class RegisterController {
    @Autowired
    protected RegisterService registerService;

    @GetMapping("/")
    public ResponseEntity<List<Register>> getRegister() {
        try {
            List<Register> registers = registerService.getRegister();
            return ResponseEntity.ok(registers);
        }
        catch (Exception e){
            return ResponseEntity.noContent().build();
        }

    }



    @PostMapping(consumes = {"text/plain"},path = "/")
    public ResponseEntity<List<Map<String, String>>> calculateRegisters(@RequestBody String inputData){
        try {
            return ResponseEntity.ok(registerService.calculateByInputData(inputData));
        }
        catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }
}
