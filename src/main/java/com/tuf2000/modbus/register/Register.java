package com.tuf2000.modbus.register;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Register {
    public String REGISTER_NAME;
    public String[] ASSOCIATED;
    public Integer NUMBER;
    public String VARIABLE_NAME;
    public String FORMAT;
    public String NOTE;
}
