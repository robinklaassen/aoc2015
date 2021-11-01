package com.robinklaassen.aoc2015.Day02;

import junit.framework.TestCase;

import static com.robinklaassen.aoc2015.Day10.Main.lookAndSay;

public class TestDay10 extends TestCase {

    public void testLookAndSay() {
        assertEquals("11", lookAndSay("1"));
        assertEquals("21", lookAndSay("11"));
        assertEquals("1211", lookAndSay("21"));
        assertEquals("111221", lookAndSay("1211"));
    }
}
