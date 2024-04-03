package com.tuf2000.modbus.logics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BITTest {

    @Test
    void convert() {
        BIT bit=new BIT();;
        assertEquals("PoorReceivedSignal",bit.convert(4));
        assertEquals("Unknown",bit.convert(3));
    }
}