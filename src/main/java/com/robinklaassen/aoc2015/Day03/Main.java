package com.robinklaassen.aoc2015.Day03;

import com.robinklaassen.aoc2015.Utils;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> puzzleInput = Utils.getPuzzleInput(3);
        char[] puzzleChars = puzzleInput.get(0).toCharArray();

        // Part one
        Map<Location, Integer> presentCounter = new HashMap<>();
        Location loc = new Location(0, 0);
        presentCounter.put(loc, 1); // Starting house present

        for (char ch : puzzleChars) {
            Direction dir = Direction.fromChar(ch);
            assert dir != null;
            loc = loc.shiftOne(dir);
            presentCounter.put(loc, presentCounter.getOrDefault(loc, 0) + 1);
        }

        System.out.println("Number of houses with at least one present: " + presentCounter.size());

        // Part two
        presentCounter = new HashMap<>();
        List<Location> locs = Arrays.asList(new Location(0, 0), new Location(0, 0));
        presentCounter.put(locs.get(0), 2); // Starting house presents

        int i = 0;
        for (char ch : puzzleChars) {
            Direction dir = Direction.fromChar(ch);
            assert dir != null;

            int idx = i % 2;
            locs.set(idx, locs.get(idx).shiftOne(dir));
            presentCounter.put(locs.get(idx), presentCounter.getOrDefault(loc, 0) + 1);

            i++;
        }

        System.out.println("With robo-Santa this becomes: " + presentCounter.size());

        /*
        After beating the puzzle I realized you don't really need to count the presents,
        just keep track of the houses you've visited...
         */

    }
}
