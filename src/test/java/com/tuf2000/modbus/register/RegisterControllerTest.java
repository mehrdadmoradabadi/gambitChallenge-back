package com.tuf2000.modbus.register;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RegisterControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testFindRegister() throws Exception {
        String inputData = "2017-01-11 19:12\n1:7579\n2:48988\n3:5064\n4:48142\n5:37967\n6:48877\n7:63814\n8:17575";
        Object MediaType;
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/register/")
                        .contentType("Text/plain")
                        .content(inputData)
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("user", "password")))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"));

    }
}