package org.example;


/**
 * https://leetcode.com/problems/make-array-elements-equal-to-zero/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        int validSelections = 0;

        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        int prefixSum = 0;

        // Iterate through the array to find valid starting positions
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int suffixSum = totalSum - prefixSum - nums[i];
                if (prefixSum == suffixSum) {
                    validSelections += 2; // Both directions are valid
                } else if (Math.abs(prefixSum - suffixSum) == 1) {
                    validSelections += 1; // Only one direction is valid
                }
            }
            prefixSum += nums[i];
        }

        return validSelections;
    }
}