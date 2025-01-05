package org.example;


/**
 * https://leetcode.com/problems/maximum-difference-between-increasing-elements/description/
 */
public class Main {
    public static void main(String[] args) {
        maximumDifference(new int[]{9, 4, 3, 2});
    }

    public static int maximumDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int maxDiff = -1;

        for (int num : nums) {
            if (num > min) {
                maxDiff = Math.max(maxDiff, num - min);
            }

            min = Math.min(min, num);
        }

        return maxDiff;
    }
}


