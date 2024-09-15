package org.example;


/**
 * https://leetcode.com/problems/split-a-string-in-balanced-strings
 */
public class Main {
    public static void main(String[] args) {
        int res = balancedStringSplit("RLLLLRRRLR");
    }

    public static int balancedStringSplit(String s) {
        int countBalancedStrings = 0;
        int localCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                localCount++;
            } else if (s.charAt(i) == 'L') {
                localCount--;
            }
            if (localCount == 0) {
                countBalancedStrings++;
            }
        }

        return countBalancedStrings;
    }

    private static int countBalancedStrings(String s, char LeftChar, char RightChar) {
        int countTemp = 0;
        Integer countBalancedStrings = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == LeftChar) {
                countTemp++;
            } else if (s.charAt(i) == RightChar) {
                countTemp--;
                if (countTemp == 0) {
                    countBalancedStrings++;
                }
            }
        }

        return countBalancedStrings;
    }

}