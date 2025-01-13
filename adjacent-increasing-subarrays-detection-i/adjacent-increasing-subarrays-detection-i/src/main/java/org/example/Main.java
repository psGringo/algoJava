package org.example;


import java.util.List;

/**
 * https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if (n < 2 * k) {
            return false;
        }

        for (int i = 0; i <= n - 2 * k; i++) {
            boolean firstIncreasing = true;
            boolean secondIncreasing = true;

            // Check first subarray
            for (int j = i; j < i + k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    firstIncreasing = false;
                    break;
                }
            }

            // Check second subarray if the first is increasing
            if (firstIncreasing) {
                for (int j = i + k; j < i + 2 * k - 1; j++) {
                    if (nums.get(j) >= nums.get(j + 1)) {
                        secondIncreasing = false;
                        break;
                    }
                }
            }

            if (firstIncreasing && secondIncreasing) {
                return true;
            }
        }

        return false;
    }
}