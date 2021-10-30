package com.robinklaassen.aoc2015.Day08;

import com.robinklaassen.aoc2015.Utils;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static String parseAscii(String input) {
        Pattern pattern = Pattern.compile("\\\\x[a-z0-9]{2}");
        Matcher m = pattern.matcher(input);
        return m.replaceAll(mr -> "!");
    }

    public static void main(String[] args) {
        List<String> puzzleInput = Utils.getPuzzleInput(8);

        int literalCounter = 0;
        int memoryCounter = 0;
        for (String line : puzzleInput) {
            literalCounter += line.length();
            String parsed = parseAscii(line);
            String escaped = StringEscapeUtils.unescapeJava(parsed);
            memoryCounter += (escaped.length() - 2);  // minus 2 accounts for start and end quotes

            System.out.printf("Input `%s`, escaped to `%s`%n", line, escaped);

        }

        System.out.printf("Total literal characters %d, total memory characters %d, difference %d%n", literalCounter, memoryCounter, literalCounter - memoryCounter);
        // 1377 too high

    }
}
