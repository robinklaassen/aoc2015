package com.robinklaassen.aoc2015.Day11;

public class Main {

    public static void main(String[] args) {
        String puzzleInput = "hepxcrrq";

        Password password = new Password(puzzleInput);

        // Part one, brute force approach
        while (!password.isValid()) {
            password.increment();
        }

        System.out.println("New valid password is: " + password);

        // Part two
        password.increment();  // To invalidate current
        while (!password.isValid()) {
            password.increment();
        }

        System.out.println("New valid password (again) is: " + password);
    }
}
