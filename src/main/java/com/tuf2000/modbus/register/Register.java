package com.tuf2000.modbus.register;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Register {
    @JsonProperty("REGISTER_NAME")
    public String REGISTER_NAME;
    @JsonProperty("ASSOCIATED")
    public String[] ASSOCIATED;
    @JsonProperty("NUMBER")
    public Integer NUMBER;
    @JsonProperty("VARIABLE_NAME")
    public String VARIABLE_NAME;
    @JsonProperty("FORMAT")
    public String FORMAT;
    @JsonProperty("NOTE")
    public String NOTE;

}
