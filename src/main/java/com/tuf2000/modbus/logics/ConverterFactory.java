package com.tuf2000.modbus.logics;

public class ConverterFactory {

    public static IBaseType createConverter(String format) {
        return switch (format) {
            case "REAL4" -> new REAL4();
            case "INTEGER" -> new INTEGER();
            case "BCD" -> new BCD();
            case "BIT" -> new BIT();
            case "LONG" -> new LONG();
            default -> null;
        };
    }
}
