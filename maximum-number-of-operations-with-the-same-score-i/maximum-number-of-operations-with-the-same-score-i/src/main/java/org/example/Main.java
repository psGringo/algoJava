package org.example;


/**
 * https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-i/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int maxOperations(int[] nums) {
        // Calculate the initial score from the first two elements
        int s = nums[0] + nums[1];
        int count = 0;
        int n = nums.length;

        // Iterate through the array in steps of 2
        for (int i = 0; i + 1 < n; i += 2) {
            // Check if the current pair sums to the initial score
            if (nums[i] + nums[i + 1] == s) {
                count++;
            } else {
                // If a pair doesn't match the initial score, stop the iteration
                break;
            }
        }

        return count;
    }
}