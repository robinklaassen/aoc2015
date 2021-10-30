package com.robinklaassen.aoc2015.Day02;

import junit.framework.TestCase;

public class TestDay07 extends TestCase {

    // Some demonstration of bitwise operations in Java
    public void testBitwise() {
        // shorts are 16 bits... ints 32 bit :)
        // but all these things are signed... so to get the full range of an unsigned short, you need an int
        int x = 123;
        int y = 456;

        assertEquals(72, x & y);
        assertEquals(507, x | y);
        assertEquals(492, x << 2);
        assertEquals(114, y >>> 2);
        assertEquals(65412, ~x & 0xffff);
        assertEquals(65079, ~y & 0xffff);
    }

}
