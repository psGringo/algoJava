package org.example;


/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int minimumOperations(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[101]; // Assuming nums contains values between 1 and 100
        int lastDuplicateIndex = -1;

        // Traverse from right to left to find the last duplicate
        for (int i = n - 1; i >= 0; i--) {
            if (seen[nums[i]]) {
                lastDuplicateIndex = i;
                break;
            }
            seen[nums[i]] = true;
        }

        // If no duplicates are found, no operations are needed
        if (lastDuplicateIndex == -1) {
            return 0;
        }

        // Calculate the number of operations required
        return (lastDuplicateIndex + 1 + 2) / 3; // Equivalent to Math.ceil((lastDuplicateIndex + 1) / 3.0)
    }
}