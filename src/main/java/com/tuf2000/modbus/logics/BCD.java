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

    public String convert(int register1, int register2, int register3) {
        String firstHex = String.format("%04x", register1);;
        String secondHex = String.format("%04x", register2);
        String thirdHex = String.format("%04x", register3);
        firstHex = firstHex.substring(2,4)+ ":"+firstHex.substring(0,2)+ ":";
        secondHex = secondHex.substring(2,4)+ " "+ secondHex.substring(0,2)+"/";
        thirdHex = thirdHex.substring(2,4)+"/"+thirdHex.substring(0,2);

        return firstHex+secondHex+thirdHex;
    }

}
