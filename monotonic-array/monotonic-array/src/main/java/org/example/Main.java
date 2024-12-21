package org.example;


/**
 * https://leetcode.com/problems/monotonic-array/description/
 */
public class Main {
    public static void main(String[] args) {
        isMonotonic(new int[]{1, 1, 1});
    }

    public static boolean isMonotonic(int[] nums) {
        boolean isIncreasing = false;
        boolean isDecreasing = false;
        boolean isAlwaysEqual = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                isIncreasing = true;
                isAlwaysEqual = false;
            }
            if (nums[i] < nums[i - 1]) {
                isDecreasing = true;
                isAlwaysEqual = false;
            }
            if (isIncreasing && isDecreasing) {
                return false;
            }
        }
        return isIncreasing || isDecreasing || isAlwaysEqual;
    }
}