package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int slidingWindowLength = j - i + 1
                if (slidingWindowLength == k) {
                    minDiff = Math.min(minDiff, getDifference(nums, i, j));
                }
            }
        }
        return minDiff;
    }

    private int getDifference(int[] nums, int i, int j) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            min = Math.min(min, nums[k]);
            max = Math.max(max, nums[k]);
        }
        return max - min;
    }
}