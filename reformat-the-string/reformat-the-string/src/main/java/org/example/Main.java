package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reformat-the-string/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public String reformat(String s) {
        List<Character> letters = new ArrayList<>();
        List<Character> digits = new ArrayList<>();

        // Separate letters and digits
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.add(c);
            } else {
                digits.add(c);
            }
        }

        // Check if reformatting is possible
        if (Math.abs(letters.size() - digits.size()) > 1) {
            return "";
        }

        // Ensure the larger list is first
        List<Character> larger = letters.size() >= digits.size() ? letters : digits;
        List<Character> smaller = letters.size() < digits.size() ? letters : digits;

        StringBuilder result = new StringBuilder();

        // Interleave characters
        for (int i = 0; i < larger.size(); i++) {
            result.append(larger.get(i));
            if (i < smaller.size()) {
                result.append(smaller.get(i));
            }
        }

        return result.toString();
    }
}