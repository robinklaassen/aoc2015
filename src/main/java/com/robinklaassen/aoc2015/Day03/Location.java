package com.robinklaassen.aoc2015.Day03;

import java.util.Objects;

public class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x && y == location.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Location shiftOne(Direction direction) {
        switch (direction) {
            case UP:
                return new Location(x, y+1);
            case DOWN:
                return new Location(x, y-1);
            case LEFT:
                return new Location(x-1, y);
            case RIGHT:
                return new Location(x+1, y);
            default:
                return null;
        }
    }
}
