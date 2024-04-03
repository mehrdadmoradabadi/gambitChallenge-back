package com.tuf2000.modbus.logics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class REAL4Test {

    @Test
    void testConvert() {
        REAL4 converter = new REAL4();
        assertEquals("-0.8851395", converter.convert(39041,48994));
        assertEquals("0.7490011", converter.convert(48777,16191));
        assertEquals("7.1011734", converter.convert(15568,16611));
    }
}