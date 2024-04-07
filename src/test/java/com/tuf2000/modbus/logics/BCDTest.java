package com.tuf2000.modbus.logics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BCDTest {

    @Test
    void testConvert() {
        BCD BCD = new BCD();
        assertEquals("10", BCD.convert(10));
        assertEquals("170", BCD.convert(10, 10));
    }

    @Test
    void convert() {
        BCD BCD = new BCD();
        assertEquals("20:19:22 11/01/17", BCD.convert(6432, 4386,5889));
    }
}