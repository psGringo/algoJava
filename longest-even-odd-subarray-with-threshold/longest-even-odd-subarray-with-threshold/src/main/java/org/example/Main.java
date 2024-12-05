package org.example;


/**
 * https://leetcode.com/problems/longest-even-odd-subarray-with-threshold/description/
 */
public class Main {
    public static void main(String[] args) {
        longestAlternatingSubarray(new int[]{4}, 1);
    }

    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (checkConditions(nums, i, j, threshold)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    private static boolean checkConditions(int[] nums, int i, int j, int threshold) {
        if (nums[i] % 2 != 0 || nums[i] > threshold) {
            return false;
        }

        for (int k = i; k <= j - 1; k++) {
            if ((nums[k] % 2) == (nums[k + 1] % 2)) {
                return false;
            }
            if (nums[k] > threshold || nums[k + 1] > threshold) {
                return false;
            }
        }
        return true;
    }
}
