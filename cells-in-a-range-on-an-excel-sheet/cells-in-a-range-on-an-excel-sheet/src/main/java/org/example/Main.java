package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public List<String> cellsInRange(String s) {
        List<String> result = new ArrayList<>();

        // Parse input
        char startCol = s.charAt(0);
        char endCol = s.charAt(3);
        int startRow = s.charAt(1) - '0';
        int endRow = s.charAt(4) - '0';

        // Generate the range
        for (char col = startCol; col <= endCol; col++) {
            for (int row = startRow; row <= endRow; row++) {
                result.add("" + col + row);
            }
        }

        return result;
    }
}