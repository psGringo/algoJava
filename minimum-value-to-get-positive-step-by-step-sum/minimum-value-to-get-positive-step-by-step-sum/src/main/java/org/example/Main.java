package org.example;


/**
 * https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/description/
 */
public class Main {
    public static void main(String[] args) {
        minStartValue(new int[]{1, 2});
    }

    public static int minStartValue(int[] nums) {
        int prefixSum = 1;
        while (!isPrefixSumOk(nums, prefixSum)) {
            prefixSum++;
        }
        return prefixSum;
    }

    private static boolean isPrefixSumOk(int[] nums, int prefixSum) {
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (prefixSum < 1) {
                return false;
            }
        }
        return true;
    }
}