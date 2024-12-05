package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-nice-substring/description/
 */
public class Main {
    public static void main(String[] args) {
        longestNiceSubstring("c");
    }

    public static String longestNiceSubstring(String s) {

        int max = 0;
        int substringX = 0;
        int substringY = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if ((j - i > max) && containsBothCases(s, i, j)) {
                    max = Math.max(max, j - i);
                    substringX = i;
                    substringY = j;
                }
            }
        }

        return max == 0 ? "" : s.substring(substringX, substringY + 1);
    }

    private static boolean containsBothCases(String s, int i, int j) {
        HashSet<Character> letters = new HashSet<>();
        for (int k = i; k <= j; k++) {
            letters.add(s.charAt(k));
        }

        for (int k = i; k <= j; k++) {
            if ((int) s.charAt(k) < 97) { // upperCase
                boolean containsLowercase = letters.contains((char)(s.charAt(k) + 32));
                if (!containsLowercase) {
                    return false;
                }
            } else { // lowerCase
                boolean containsUppercase = letters.contains((char)(s.charAt(k) - 32));
                if (!containsUppercase) {
                    return false;
                }
            }
        }

        return true;
    }
}
