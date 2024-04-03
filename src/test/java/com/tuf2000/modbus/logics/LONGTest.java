package com.tuf2000.modbus.logics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LONGTest {

    @Test
    void convert() {
        LONG  converter = new LONG();

        assertEquals("5", converter.convert(5));
        assertEquals("0", converter.convert(0));
        assertEquals("1", converter.convert(1));
        assertEquals("7", converter.convert(7));
        assertEquals("9", converter.convert(9));
    }

    @Test
    void testConvert() {
        LONG  converter = new LONG();
        assertEquals("-56", converter.convert(65480, 65535));
        assertEquals("87", converter.convert(87, 0));
        assertEquals("0", converter.convert(0, 0));
    }
}