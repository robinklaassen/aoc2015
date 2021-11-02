package com.robinklaassen.aoc2015.Day02;

import com.robinklaassen.aoc2015.Day11.Password;
import junit.framework.TestCase;

public class TestDay11 extends TestCase {

    public void testPasswordRules() {
        Password p1 = new Password("hijklmmn");

        assertTrue(p1.containsStraight());
        assertTrue(p1.containsForbiddenCharacter());
        assertFalse(p1.containsTwoPairs());

        Password p2 = new Password("abbceffg");
        assertFalse(p2.containsStraight());
        assertFalse(p2.containsForbiddenCharacter());
        assertTrue(p2.containsTwoPairs());
    }

    public void testPasswordValid() {
        assertTrue(new Password("abcdffaa").isValid());
        assertTrue(new Password("ghjaabcc").isValid());
    }

    public void testIncrement() {
        Password p1 = new Password("aa");
        p1.increment();
        assertEquals("ab", p1.toString());

        Password p2 = new Password("azz");
        p2.increment();
        assertEquals("baa", p2.toString());
    }

}
