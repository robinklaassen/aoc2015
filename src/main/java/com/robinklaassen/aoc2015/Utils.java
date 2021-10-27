package com.robinklaassen.aoc2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    public static ArrayList<String> getPuzzleInput(int day) {

        ArrayList<String> output = new ArrayList<>();

        String filePath = String.format("src/main/resources/puzzle-input/day%02d.txt", day);
        File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                output.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return output;
    }

}
