package org.example;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Flip negative numbers
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        // To maximize the sum, sorting again and choosing the min element e.g. first one
        // even count of k doesn't affect as it's will not change the sign of element
        // Step 3: Handle remaining flips
        // Sort again to ensure the smallest absolute value is at index 0
        Arrays.sort(nums);
        if (k % 2 == 1) {
            nums[0] = -nums[0];
        }

        // Step 4: Calculate the sum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return sum;
    }
}