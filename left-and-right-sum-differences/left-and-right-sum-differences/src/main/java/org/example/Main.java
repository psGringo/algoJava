package org.example;


/**
 * https://leetcode.com/problems/left-and-right-sum-differences/description/
 */
public class Main {
    public static void main(String[] args) {
        leftRightDifference(new int[]{10, 4, 8, 3});
    }

    public static int[] leftRightDifference(int[] nums) {
        int[] cumulativeFromLeft = new int[nums.length];
        int[] cumulativeFromRight = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                cumulativeFromLeft[i] = nums[i];
            } else {
                cumulativeFromLeft[i] = nums[i] + cumulativeFromLeft[i - 1];
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                cumulativeFromRight[i] = nums[i];
            } else {
                cumulativeFromRight[i] = nums[i] + cumulativeFromRight[i + 1];
            }
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = Math.abs(cumulativeFromLeft[i] - cumulativeFromRight[i]);
        }

        return res;
    }
}