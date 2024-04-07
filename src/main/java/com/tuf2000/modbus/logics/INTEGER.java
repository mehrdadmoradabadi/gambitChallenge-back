package com.tuf2000.modbus.logics;

public class INTEGER implements IBaseType {

    @Override
    public String convert(int register) {
        return String.valueOf(Integer.parseInt(Integer.toBinaryString(register), 2));
    }

    @Override
    public String convert(int register1, int register2) {
        return null;
    }



}
