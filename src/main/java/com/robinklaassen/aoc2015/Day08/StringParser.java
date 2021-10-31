package com.robinklaassen.aoc2015.Day08;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {

    public StringParser() {

    }

    /**
     * Goes through provided string characters in order and builds a new string.
     * @param str the input string.
     * @return the parsed string.
     */
    public String parse(String str) {
        List<Character> chars = str.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        List<Character> parsedChars = new ArrayList<>();

        while (!chars.isEmpty()) {
            Character ch = chars.remove(0);
            if (ch == '\\') {
                Character ch2 = chars.remove(0);
                if (ch2 == 'x') {
                    String hex = "" + chars.remove(0) + chars.remove(0);
                    parsedChars.add(hexToChar(hex));
                } else {
                    parsedChars.add(ch2);
                }
            } else {
                parsedChars.add(ch);
            }
        }

        // Remove first and last character assuming they're quotes
        parsedChars.remove(0);
        parsedChars.remove(parsedChars.size() - 1);

        return parsedChars.stream().map(String::valueOf).collect(Collectors.joining());
    }

    protected Character hexToChar(String hex) {
        return (char) Integer.parseInt(hex, 16);
    }

}
