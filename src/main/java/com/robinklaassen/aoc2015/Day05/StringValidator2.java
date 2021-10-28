package com.robinklaassen.aoc2015.Day05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator2 {

    private final String str;

    public StringValidator2(String str) {
        this.str = str;
    }

    public boolean isNice() {
        return niceRule1() && niceRule2();
    }

    // String should contain any pair twice without overlapping
    private boolean niceRule1() {
        Pattern pattern = Pattern.compile("([a-z]{2}).*\\1");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    // String should contain at least one letter that repeats with one letter in between
    private boolean niceRule2() {
        Pattern pattern = Pattern.compile("([a-z])[a-z]\\1");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
}
