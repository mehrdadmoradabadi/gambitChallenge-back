package com.tuf2000.modbus.logics;

import java.math.BigInteger;

public class REAL4 implements IBaseType {
    @Override
    public String convert(int register) {
        return null;
    }

    @Override
    public String convert(int register1, int register2) {
        String firstHex = Integer.toHexString(register2);
        String secondHex = Integer.toHexString(register1);
        String sum = firstHex + secondHex;
        BigInteger bigInt = new BigInteger(sum, 16);
        return String.valueOf(Float.intBitsToFloat(bigInt.intValue()));
    }


}
