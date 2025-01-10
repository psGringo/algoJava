package org.example;


import java.util.HashMap;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/description/
 */
public class Main {
    public static void main(String[] args) {
        containsPattern(new int[]{2, 2}, 1, 2);
    }

    public static boolean containsPattern(int[] arr, int m, int k) {
        // m*k maxLength of repetitions
        int n = arr.length;
        for (int i = 0; i <= n - m * k; i++) {
            boolean isPattern = true; // consider pattern is ok

            for (int j = 0; j < m * (k -1); j++) {
                if (arr[i + j] != arr[i + j + m]) {
                    isPattern = false;
                    break;
                }
            }

            if (isPattern) {
                return true;
            }
        }

        return false;
    }
}