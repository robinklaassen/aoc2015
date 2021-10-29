package com.robinklaassen.aoc2015.Day06;

public enum Instruction {
    ON,
    OFF,
    TOGGLE;

    public static Instruction fromString(String str) {
        switch(str) {
            case "turn on":
                return Instruction.ON;
            case "turn off":
                return Instruction.OFF;
            case "toggle":
                return Instruction.TOGGLE;
            default:
                throw new IllegalArgumentException();
        }
    }
}
