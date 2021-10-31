package com.robinklaassen.aoc2015.Day08;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringEncoder {

    public StringEncoder() {

    }

    /**
     * Goes through provided string characters in order and builds a new string.
     * @param str the input string.
     * @return the parsed string.
     */
    public String encode(String str) {
        List<Character> chars = str.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        List<Character> parsedChars = new ArrayList<>();

        // Always start with a double quote!
        parsedChars.add('"');

        while (!chars.isEmpty()) {
            Character ch = chars.remove(0);
            if (ch == '"' || ch == '\\') {
                parsedChars.add('\\');
            }
            parsedChars.add(ch);
        }

        // And end with double quote too
        parsedChars.add('"');

        return parsedChars.stream().map(String::valueOf).collect(Collectors.joining());
    }

}
