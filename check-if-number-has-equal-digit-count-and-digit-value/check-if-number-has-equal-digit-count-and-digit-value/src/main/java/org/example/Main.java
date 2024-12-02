package org.example;


/**
 * https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/description/
 */
public class Main {
    public static void main(String[] args) {
        digitCount("030");
    }

    public static boolean digitCount(String num) {
        int[] fq = new int[10];
        for (int i = 0; i < num.length(); i++) {
            int n = Character.digit(num.charAt(i), 10);
            fq[n]++;
        }

        for (int i = 0; i < num.length(); i++) {
            int n = Character.digit(num.charAt(i), 10);
            if (fq[i] != n) {
                return false;
            }
        }
        return true;
    }

}