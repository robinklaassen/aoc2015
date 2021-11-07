package com.robinklaassen.aoc2015.Day14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reindeer {

    private final String name;
    private final int speed;
    private final int flyDuration;
    private final int restDuration;

    private int points;

    public Reindeer(String name, int speed, int flyDuration, int restDuration) {
        this.name = name;
        this.speed = speed;
        this.flyDuration = flyDuration;
        this.restDuration = restDuration;

        this.points = 0;
    }

    public static Reindeer fromString(String str) {
        Pattern p = Pattern.compile("(\\w+) can fly (\\d+) km/s for (\\d+) seconds, but then must rest for (\\d+) seconds.");
        Matcher m = p.matcher(str);
        while (m.find()) {
            return new Reindeer(
                    m.group(1),
                    Integer.parseInt(m.group(2)),
                    Integer.parseInt(m.group(3)),
                    Integer.parseInt(m.group(4))
            );
        }

        throw new RuntimeException("Could not instantiate Reindeer from string");
    }

    public int getDistanceOfOneFlight() {
        return speed * flyDuration;
    }

    public int getDistanceAfterTime(int time) {

        int fullFlights = Math.floorDiv(time, flyDuration + restDuration);
        int restTime = Math.floorMod(time, flyDuration + restDuration);

        return fullFlights * getDistanceOfOneFlight() + Math.min(restTime, flyDuration) * speed;
    }

    public int getPoints() {
        return this.points;
    }

    public void awardPoint() {
        this.points++;
    }

}
