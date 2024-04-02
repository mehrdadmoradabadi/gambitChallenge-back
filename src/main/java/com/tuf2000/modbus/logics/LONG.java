package com.tuf2000.modbus.logics;

import java.math.BigInteger;

public class LONG implements IBaseType {

    @Override
    public String convert(int register) {
        return String.valueOf(Integer.parseInt(Integer.toBinaryString(register), 2));
    }

    @Override
    public String convert(int register1, int register2) {
        String firstHex = Integer.toHexString(register2);
        String secondHex = Integer.toHexString(register1);
        String sum = firstHex + secondHex;
        if (sum.length() == 8) {
            byte[] bytes = new BigInteger(sum, 16).toByteArray();
            return String.valueOf(bytes[4]);
        } else {
            return String.valueOf(Long.parseLong(sum, 16));
        }
    }
}
