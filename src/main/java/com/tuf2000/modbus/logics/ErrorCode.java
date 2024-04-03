package com.tuf2000.modbus.logics;

import java.util.Arrays;
import java.util.Optional;

public enum ErrorCode {
    Unknown (0), // Bit0
    NoReceivedSignal(1), // Bit1
    LowReceivedSignal(2), // Bit2
    PoorReceivedSignal(4), // Bit3
    PipeEmpty(8), // Bit4
    HardwareFailure(16), // Bit4
    ReceivingCircuitsGainInAdjusting(32), // Bit5
    FrequencyAtTheFrequencyOutputOverflow(64), // Bit6
    CurrentAt420mAOverflow(128), // Bit7
    RAMChecksumError(256), // Bit8
    MainClockOrTimerClockError(512), // Bit9
    ParametersChecksumError(1024), // Bit10
    ROMChecksumError(2048), // Bit11
    TemperatureCircuitsError(4096), // Bit12
    Reserved(8192), // Bit13
    InternalTimerOverflow(16384), // Bit14
    AnalogInputOverRange(32768); // Bit15

    private final int errorCodeNumber;

    ErrorCode(int errorCodeNumber) {
        this.errorCodeNumber = errorCodeNumber;
    }

    public int getErrorCodeNumber() {
        return errorCodeNumber;
    }

    public static ErrorCode getByErrorCodeNumber(int errorCodeNumber) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (errorCode.getErrorCodeNumber() == errorCodeNumber) {
                return errorCode;
            }
        }
        return Unknown; // Default to Unknown if not found
    }
}
