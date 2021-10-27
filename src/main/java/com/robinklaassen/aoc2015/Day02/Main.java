package com.robinklaassen.aoc2015.Day02;

import com.robinklaassen.aoc2015.Utils;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> puzzleInput = Utils.getPuzzleInput(2);

        // Part one
        int totalPaper = 0;
        for (String line : puzzleInput) {
            Present present = Present.fromLine(line);
            totalPaper += present.getRequiredPaper();
        }

        System.out.println("Total paper required: " + totalPaper);

        // Part two
        List<Present> presents = puzzleInput.stream().map(Present::fromLine).collect(Collectors.toList());
        int totalRibbon = presents.stream().mapToInt(Present::getRibbonLength).sum();

        System.out.println("Total ribbon length required: " + totalRibbon);
    }
}
