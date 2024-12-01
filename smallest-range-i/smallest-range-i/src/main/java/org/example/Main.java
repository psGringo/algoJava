package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/smallest-range-i/
 */
public class Main {
    public static void main(String[] args) {
        smallestRangeI(new int[]{1}, 0);
    }

    public static int smallestRangeI(int[] nums, int k) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        if (min + k >= max - k) {
            return 0;
        }
        return max - k - (min + k);
    }
}