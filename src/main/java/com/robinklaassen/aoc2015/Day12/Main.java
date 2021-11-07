package com.robinklaassen.aoc2015.Day12;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.robinklaassen.aoc2015.Utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    // This is the worst Java code I probably have ever written.
    public static int countNumbers(Object obj) {
        int total = 0;
        boolean red = false;

        if (obj instanceof Integer) {
            total += (int) obj;
        } else if (obj instanceof ArrayList) {
            total += ((ArrayList) obj).stream().mapToInt(Main::countNumbers).sum();
        } else if (obj instanceof LinkedHashMap) {
            if (((LinkedHashMap) obj).values().contains("red")) {
                return 0;
            }
            total += ((LinkedHashMap) obj).values().stream().mapToInt(Main::countNumbers).sum();
        } else if (obj instanceof String) {
            // pass
        } else {
            throw new IllegalArgumentException("Unknown object type: " + obj.getClass());
        }

        return total;
    }

    public static void main(String[] args) throws JsonProcessingException {
        String puzzleInput = Utils.getPuzzleInput(12).get(0);

        // Part one
        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(puzzleInput);

        int total = m.results().mapToInt(mr -> Integer.parseInt(mr.group(0))).sum();
        System.out.println("Sum of numbers in document: " + total);

        // Part two
        @SuppressWarnings("unchecked")
        Map<String, Object> doc = new ObjectMapper().readValue(puzzleInput, LinkedHashMap.class);

        int total2 = countNumbers(doc);

        System.out.println("Sum of numbers in document, v2: " + total2);

    }
}
