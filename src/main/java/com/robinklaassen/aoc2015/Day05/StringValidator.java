package com.robinklaassen.aoc2015.Day05;

import org.apache.commons.lang3.StringUtils;

public class StringValidator {

    private final String str;

    public StringValidator(String str) {
        this.str = str;
    }

    public boolean isNice() {
        return niceRule1() && niceRule2() && niceRule3();
    }

    // String should contain at least 3 vowels
    private boolean niceRule1() {
        String[] vowels = {"a", "e", "i", "o", "u"};
        int vowelCount = 0;

        for (String vowel : vowels) {
            vowelCount += StringUtils.countMatches(str, vowel);
        }

        return vowelCount >= 3;
    }

    // String should have at least one letter twice in a row
    private boolean niceRule2() {
        for (char letter : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
            if (str.contains("" + letter + letter)) {
                return true;
            }
        }
        return false;
    }

    // String may not contain one of the given combinations
    private boolean niceRule3() {
        String[] forbiddenCombinations = {"ab", "cd", "pq", "xy"};
        for (String forbiddenCombination : forbiddenCombinations) {
            if (str.contains(forbiddenCombination)) {
                return false;
            }
        }
        return true;
    }
}
