package org.example;


/**
 * https://leetcode.com/problems/longest-alternating-subarray/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int alternatingSubarray(int[] nums) {
        int maxLength = -1;
        int currentLength = 1;
        int expectedDiff = 1;

        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff == expectedDiff) {
                currentLength++;
                expectedDiff *= -1;
            } else {
                if (diff == 1) {
                    currentLength = 2;
                    expectedDiff = -1;
                } else {
                    currentLength = 1;
                    expectedDiff = 1;
                }
            }
            if (currentLength > 1) {
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}