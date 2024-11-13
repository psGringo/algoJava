package org.example;


/**
 * https://leetcode.com/problems/check-balanced-string/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean isBalanced(String num) {
        int sumEvens = 0;
        int sumOdds = 0;
        for (int i = 0; i < num.length(); i++) {
            if (i % 2 == 0) {
                sumEvens += num.charAt(i) - '0';
            } else {
                sumOdds += num.charAt(i) - '0';
            }
        }
        return sumEvens == sumOdds;
    }

}