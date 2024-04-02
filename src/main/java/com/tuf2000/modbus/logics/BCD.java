package com.tuf2000.modbus.logics;

public class BCD implements IBaseType {

    @Override
    public String convert(int register) {
        return String.valueOf(Integer.parseInt(Integer.toBinaryString(register), 2));
    }

    @Override
    public String convert(int register1, int register2) {

        String firstHex = Integer.toHexString(register2);
        String secondHex = Integer.toHexString(register1);
        String sum = firstHex + secondHex;
        return String.valueOf(Integer.parseInt(sum, 16));
    }


}
