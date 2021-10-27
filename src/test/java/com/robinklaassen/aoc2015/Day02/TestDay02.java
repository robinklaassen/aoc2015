package com.robinklaassen.aoc2015.Day02;

import junit.framework.TestCase;

public class TestDay02 extends TestCase {

    private Present present1 = new Present(2, 3, 4);
    private Present present2 = new Present(1, 1, 10);

    public void testPresentRequiredPaper() {
        assertEquals(58, present1.getRequiredPaper());
        assertEquals(43, present2.getRequiredPaper());
    }

    public void testPresentFromLine() {
        Present present = Present.fromLine("2x3x4");
        assertEquals(present1, present);
    }

    public void testPresentRibbonLength() {
        assertEquals(34, present1.getRibbonLength());
        assertEquals(14, present2.getRibbonLength());
    }

}
