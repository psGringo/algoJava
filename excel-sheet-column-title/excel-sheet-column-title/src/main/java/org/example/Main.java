package org.example;


/**
 * https://leetcode.com/problems/excel-sheet-column-title/description/
 */
public class Main {
    public static void main(String[] args) {
        convertToTitle(1);
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--; // to zero based
            var letter = (char) ('A' + columnNumber % 26);
            sb.append(letter);
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

}