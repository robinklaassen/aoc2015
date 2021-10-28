package com.robinklaassen.aoc2015.Day03;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public static Direction fromChar(char ch) {
        switch(ch) {
            case '<':
                return Direction.LEFT;
            case '>':
                return Direction.RIGHT;
            case '^':
                return Direction.UP;
            case 'v':
                return Direction.DOWN;
            default:
                return null;
        }
    }
}
