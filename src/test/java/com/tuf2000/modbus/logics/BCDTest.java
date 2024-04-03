package com.tuf2000.modbus.logics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BCDTest {

    @Test
    void testConvert() {
        BCD BCD = new BCD();
        assertEquals("1010", BCD.convert(10));
        assertEquals("10101010", BCD.convert(10, 10));
    }
}