package com.robinklaassen.aoc2015.Day10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static String lookAndSay(String str) {
        StringBuilder output = new StringBuilder();

        Pattern p = Pattern.compile("1+|2+|3+");
        Matcher m = p.matcher(str);

        while (m.find()) {
            output.append(m.group().length());
            output.append(m.group().charAt(0));
        }

        return output.toString();
    }

    public static void main(String[] args) {
        String puzzleInput = "1113222113";

        // Part one
        String line = puzzleInput;
        for (int i = 0; i < 40; i++) {
            line = lookAndSay(line);
        }

        System.out.println("Length of final sequence after 40 iterations is: " + line.length());

        // Part two
        line = puzzleInput;
        for (int i = 0; i < 50; i++) {
            line = lookAndSay(line);
        }

        System.out.println("Length of final sequence after 50 iterations is: " + line.length());
    }
}
