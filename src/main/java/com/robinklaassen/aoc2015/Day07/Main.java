package com.robinklaassen.aoc2015.Day07;

import com.robinklaassen.aoc2015.Utils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> puzzleInput = Utils.getPuzzleInput(7);

        // Part one
        RecursiveCircuit circuit = RecursiveCircuit.fromLines(puzzleInput);
        int answer = circuit.getSignal("a");
        System.out.printf("Signal provided to wire a: %d%n", answer);

        // Part two
        RecursiveCircuit circuit2 = RecursiveCircuit.fromLines(puzzleInput);
        circuit2.wires.put("b", Integer.toString(answer));
        int answer2 = circuit2.getSignal("a");
        System.out.printf("Signal provided to wire a with override of b: %d%n", answer2);
    }

}
