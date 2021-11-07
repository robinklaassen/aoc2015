package com.robinklaassen.aoc2015.Day14;

import com.robinklaassen.aoc2015.Utils;

import java.util.List;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        List<String> puzzleInput = Utils.getPuzzleInput(14);
        List<Reindeer> reindeers = puzzleInput.stream().map(Reindeer::fromString).collect(Collectors.toList());

        // Part one
        int bestDistance = reindeers.stream().mapToInt(r -> r.getDistanceAfterTime(2503)).max().getAsInt();
        System.out.println("Best distance found: " + bestDistance);

        // Part two
        for (int i = 1; i <= 2503; i++) {
            int finalI = i;
            int best = reindeers.stream().mapToInt(r -> r.getDistanceAfterTime(finalI)).max().getAsInt();
            reindeers.stream().filter(r -> r.getDistanceAfterTime(finalI) == best).forEach(Reindeer::awardPoint);

            /*
             Below is my first version of this points mechanic, but this doesn't take into account ties for first place.
                reindeers.sort(Comparator.comparing(r -> r.getDistanceAfterTime(finalI)));
                reindeers.get(reindeers.size() - 1).awardPoint();
            */
        }
        int maxPoints = reindeers.stream().mapToInt(Reindeer::getPoints).max().getAsInt();
        System.out.println("Max number of points: " + maxPoints);
    }
}
