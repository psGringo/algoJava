package org.example;


/**
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     * looking for 2 maximums here, if max1 > 2 * max2, then we have the correct answer
     *
     * @param nums
     * @return
     */
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0; // Only one element, it is trivially the largest
        }

        int max1 = -1, max2 = -1, index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                // Update max1 and max2
                max2 = max1;
                max1 = nums[i];
                index = i;
            } else if (nums[i] > max2) {
                // Update only max2
                max2 = nums[i];
            }
        }

        // Check if max1 is at least twice max2
        return max1 >= 2 * max2 ? index : -1;
    }
}