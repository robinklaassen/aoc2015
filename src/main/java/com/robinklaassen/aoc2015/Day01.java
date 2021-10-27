package com.robinklaassen.aoc2015;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class Day01 {

    private static int calculateFinalFloor(String input) {
        int countUp = StringUtils.countMatches(input, "(");
        int countDown = StringUtils.countMatches(input, ")");
        return countUp - countDown;
    }

    private static int calculateFirstBasementPosition(String input) {
        int floor = 0;
        int position = 1;
        for (char ch : input.toCharArray()) {
            int change = (ch == '(') ? 1 : -1;
            floor += change;
            if (floor == -1) {
                break;
            }
            position++;
        }

        return position;
    }

    public static void main(String[] args) {
        ArrayList<String> puzzleInput = Utils.getPuzzleInput(1);

        // Part one
        int resultOne = calculateFinalFloor(puzzleInput.get(0));
        System.out.println("Result for part one: " + resultOne);

        // Part two
        int resultTwo = calculateFirstBasementPosition(puzzleInput.get(0));
        System.out.println("Result for part two: " + resultTwo);
    }


}
