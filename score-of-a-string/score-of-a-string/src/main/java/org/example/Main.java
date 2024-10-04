package org.example;


/**
 * https://leetcode.com/problems/score-of-a-string/description/
 */
public class Main {
    public static void main(String[] args) {
        scoreOfString("hello");
    }

    public static int scoreOfString(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            sum += Math.abs(s.charAt(i + 1) - s.charAt(i));
        }

        return sum;
    }

}