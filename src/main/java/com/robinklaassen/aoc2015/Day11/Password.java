package com.robinklaassen.aoc2015.Day11;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Password {

    private List<Character> password;

    private final char[] forbiddenChars = {'i', 'o', 'l'};
    private final List<String> straights = generateStraights();
    private final Pattern letterPairPattern = Pattern.compile("(\\w)\\1");

    private List<String> generateStraights() {
        List<String> straights = new ArrayList<>();
        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int i = 0; i < 24; i++) {
            straights.add("" + letters[i] + letters[i + 1] + letters[i + 2]);
        }
        return straights;
    }


    public Password(String password) {
        this.password = password.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
    }

    public void increment() {
        int i = this.password.size() - 1;  // Start at last character
        while (this.password.get(i) == 'z') {
            this.password.set(i, 'a');
            i--;
        }
        this.password.set(i, (char) (this.password.get(i) + 1));
    }

    public boolean containsForbiddenCharacter() {
        for (char forbiddenChar : this.forbiddenChars) {
            if (this.password.contains(forbiddenChar)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsTwoPairs() {
        Matcher m = this.letterPairPattern.matcher(this.toString());
        return m.results().count() >= 2;
    }

    public boolean containsStraight() {
        for (String straight : straights) {
            if (this.toString().contains(straight)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValid() {
        return !containsForbiddenCharacter() && containsStraight() && containsTwoPairs();
    }


    public String toString() {
        return this.password.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
