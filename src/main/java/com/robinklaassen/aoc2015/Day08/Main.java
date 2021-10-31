package com.robinklaassen.aoc2015.Day08;

import com.robinklaassen.aoc2015.Utils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> puzzleInput = Utils.getPuzzleInput(8);

        // Part one
        StringParser parser = new StringParser();

        int literalCounter = 0;
        int memoryCounter = 0;
        for (String line : puzzleInput) {
            literalCounter += line.length();
            String parsed = parser.parse(line);
            memoryCounter += parsed.length();

            System.out.printf("Input `%s`, parsed to `%s`%n", line, parsed);

        }

        System.out.printf("Total literal characters %d, total memory characters %d, difference %d%n", literalCounter, memoryCounter, literalCounter - memoryCounter);

        // Part two
        StringEncoder encoder = new StringEncoder();

        literalCounter = 0;
        int encodedCounter = 0;
        for (String line : puzzleInput) {
            literalCounter += line.length();
            String encoded = encoder.encode(line);
            encodedCounter += encoded.length();

            System.out.printf("Input `%s`, encoded to `%s`%n", line, encoded);

        }

        System.out.printf("Total literal characters %d, total encoded characters %d, difference %d%n", literalCounter, encodedCounter, encodedCounter - literalCounter);
    }
}
