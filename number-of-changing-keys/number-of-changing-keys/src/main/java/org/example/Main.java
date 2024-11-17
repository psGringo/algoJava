package org.example;


/**
 * https://leetcode.com/problems/number-of-changing-keys/description/
 */
public class Main {
    public static void main(String[] args) {
        countKeyChanges("AaAaAaaAa");
    }

    private static final int DIFF_BETWEEN_UPPERCASE_AND_LOWEERCASE_LETTER = 32;

    public static int countKeyChanges(String s) {
        int count = 0;
        int prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            int diff = Math.abs((int) s.charAt(i) - (int) prev);
            if (diff != DIFF_BETWEEN_UPPERCASE_AND_LOWEERCASE_LETTER && diff != 0) {
                count++;
            }
            prev = s.charAt(i);
        }
        return count;
    }
}