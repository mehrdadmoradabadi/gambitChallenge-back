package com.tuf2000.modbus.logics;

import ch.qos.logback.core.spi.ErrorCodes;

public class BIT implements IBaseType {
    @Override
    public String convert(int register) {

        return String.valueOf(ErrorCode.getByErrorCodeNumber(register));
    }

    @Override
    public String convert(int register1, int register2) {
        return null;
    }


}
