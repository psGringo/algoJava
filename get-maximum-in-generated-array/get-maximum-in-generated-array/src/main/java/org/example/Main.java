package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }

        // Create the nums array
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;

        int max = 1; // Initialize max as nums[1]

        // Generate nums array and track maximum
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[i / 2] + nums[i / 2 + 1];
            }
            max = Math.max(max, nums[i]);
        }

        return max;
    }
}