package com.robinklaassen.aoc2015.Day07;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecursiveCircuit {

    public Map<String, String> wires;
    public Map<String, Integer> cache = new HashMap<>();

    public RecursiveCircuit(Map<String, String> wires) {
        this.wires = wires;
    }

    public static RecursiveCircuit fromLines(List<String> lines) {
        Map<String, String> wires = new HashMap<>();
        for (String line : lines) {
            String[] items = line.split(" -> ");
            wires.put(items[1], items[0]);
        }
        return new RecursiveCircuit(wires);
    }

    // The magic: memoization (otherwise known as a cache)
    public int getSignal(String wire) {
        if (cache.containsKey(wire)) {
            return cache.get(wire);
        }

        int signal = calculateSignal(wire);
        System.out.printf("Caching wire %s with value %d%n", wire, signal);
        cache.put(wire, signal);
        return signal;
    }

    public int calculateSignal(String wire) {
        String value = this.wires.get(wire);

        // Input is a single number
        if (NumberUtils.isNumber(value)) {
            return Integer.parseInt(value);
        }

        // Input is a single wire identifier
        if (!value.contains(" ")) {
            return getSignal(value);
        }

        // Complement
        if (value.startsWith("NOT ")) {
            // Including some magic to make sure the result is not negative (bit masking for signed/unsigned)
            return ~getSignal(value.substring(4)) & 0xffff;
        }

        // Other options
        String[] items = value.split(" ");
        String operator = items[1];
        int first = NumberUtils.isNumber(items[0]) ? Integer.parseInt(items[0]) : getSignal(items[0]);
        int second = NumberUtils.isNumber(items[2]) ? Integer.parseInt(items[2]) : getSignal(items[2]);

        switch (operator) {
            case "AND":
                return (first & second);
            case "OR":
                return (first | second);
            case "LSHIFT":
                return (first << second);
            case "RSHIFT":
                return (first >>> second);
        }

        // If we're still here, something fucked up :)
        throw new RuntimeException(String.format("Don't know how to handle value `%s`", value));

    }

}
