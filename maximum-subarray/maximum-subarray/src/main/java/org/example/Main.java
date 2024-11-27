package org.example;


/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     * Kadane algo, all sums end up at some index, we compare that sum with new starting array
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // Find the maximum sum ending at index i by either extending
            // the maximum sum subarray ending at index i - 1 or by
            // starting a new subarray from index i
            max = Math.max(max + nums[i], nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}