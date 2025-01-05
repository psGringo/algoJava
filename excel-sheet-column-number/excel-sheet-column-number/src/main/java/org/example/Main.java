package org.example;


/**
 * https://leetcode.com/problems/excel-sheet-column-number/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            int value = c - 'A' + 1; // Convert character to corresponding value
            result = result * 26 + value; // Update the result
        }

        return result;
    }
}