package com.robinklaassen.aoc2015.Day04;

import org.apache.commons.codec.digest.DigestUtils;

public class Main {

    public static void main(String[] args) {

        String puzzleInput = "iwrupvqb";

        // Part one (and two, sneakily)
        int i = 0;
        String hash = null;
        boolean found = false;
        while (!found) {
            i++;
            hash = DigestUtils.md5Hex(puzzleInput + i);
            if (hash.startsWith("000000")) {
                found = true;
            }
        }

        System.out.printf("Found input %d with resulting hash %s%n", i, hash);

    }
}
