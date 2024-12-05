package org.example;

import java.util.Arrays;


/**
 * https://leetcode.com/problems/longest-harmonious-subsequence/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int maxLength = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j >= 0; j--) {
                if (j - i + 1 > 1 && nums[j] - nums[i] == 1) { // min. count for subsequence
                    maxLength = Math.max(maxLength, j - i + 1);
                    break; // this is the maximum for that sliding window
                }
            }
        }
        return maxLength;
    }
}