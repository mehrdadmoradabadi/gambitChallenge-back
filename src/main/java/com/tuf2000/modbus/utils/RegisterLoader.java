package com.tuf2000.modbus.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuf2000.modbus.register.Register;
import org.springframework.core.io.ClassPathResource;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
public class RegisterLoader {

    public static List<Register> loadRegisters() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("static/data.json");
        Register[] registers = objectMapper.readValue(resource.getInputStream(), Register[].class);
        return Arrays.asList(registers);
    }
}
