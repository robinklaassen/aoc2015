package com.robinklaassen.aoc2015.Day06;

import com.robinklaassen.aoc2015.Utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        List<String> puzzleInput = Utils.getPuzzleInput(6);

        // Part one
        LightGrid grid = new LightGrid(1000, 1000);
        for (String line : puzzleInput) {
            Pattern pattern = Pattern.compile("([a-z\\s]*) (\\d+),(\\d+) through (\\d+),(\\d+)");
            Matcher match = pattern.matcher(line);
            if (match.find()) {
                grid.processInstruction(
                        Integer.parseInt(match.group(2)),
                        Integer.parseInt(match.group(3)),
                        Integer.parseInt(match.group(4)),
                        Integer.parseInt(match.group(5)),
                        Instruction.fromString(match.group(1))
                );
            } else {
                throw new RuntimeException(String.format("No regex match found for line `%s`", line));
            }
        }

        System.out.printf("Number of lights turned on: %d", grid.countTurnedOn());

        // Part two
        LightGrid2 grid2 = new LightGrid2(1000, 1000);
        for (String line : puzzleInput) {
            Pattern pattern = Pattern.compile("([a-z\\s]*) (\\d+),(\\d+) through (\\d+),(\\d+)");
            Matcher match = pattern.matcher(line);
            if (match.find()) {
                grid2.processInstruction(
                        Integer.parseInt(match.group(2)),
                        Integer.parseInt(match.group(3)),
                        Integer.parseInt(match.group(4)),
                        Integer.parseInt(match.group(5)),
                        Instruction.fromString(match.group(1))
                );
            } else {
                throw new RuntimeException(String.format("No regex match found for line `%s`", line));
            }
        }

        System.out.printf("Total brightness of the grid: %d", grid2.countBrightness());

    }
}
