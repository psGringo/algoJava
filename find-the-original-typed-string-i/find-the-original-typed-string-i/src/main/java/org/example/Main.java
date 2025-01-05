package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public int possibleStringCount(String word) {
        int count = 1; // At least one possible original string

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            }
        }

        return count;
    }
}