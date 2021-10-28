package com.robinklaassen.aoc2015.Day02;

import com.robinklaassen.aoc2015.Day05.StringValidator;
import junit.framework.TestCase;

public class TestDay05 extends TestCase {

    public void testPartOne() {
        assertTrue(new StringValidator("ugknbfddgicrmopn").isNice());
        assertTrue(new StringValidator("aaa").isNice());

        assertFalse(new StringValidator("jchzalrnumimnmhp").isNice());
        assertFalse(new StringValidator("haegwjzuvuyypxyu").isNice());
        assertFalse(new StringValidator("dvszwmarrgswjxmb").isNice());
    }
}
