package org.example;


/**
 * https://leetcode.com/problems/minimum-sum-of-mountain-triplets-i/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int minimumSum(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (i < j && j < k && nums[i] < nums[j] && nums[k] < nums[j]) {
                        minSum = Math.min(minSum, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}