package com.robinklaassen.aoc2015.Day05;

import com.robinklaassen.aoc2015.Utils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> puzzleInput = Utils.getPuzzleInput(5);

        // Part one
        int niceCount = 0;
        for (String str : puzzleInput) {
            if (new StringValidator(str).isNice()) {
                niceCount++;
            }
        }

        System.out.printf("Number of nice strings found: %d", niceCount);

        // Part two
        niceCount = 0;
        for (String str : puzzleInput) {
            if (new StringValidator2(str).isNice()) {
                niceCount++;
            }
        }

        System.out.printf("Number of nice strings with second rule set: %d", niceCount);

    }
}
