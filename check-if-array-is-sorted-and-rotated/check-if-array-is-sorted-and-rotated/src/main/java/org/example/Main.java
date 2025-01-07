package org.example;


/**
 * https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean check(int[] nums) {
        int countBreaks = 0;
        int n = nums.length;

        // Count the number of breaks in order
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                countBreaks++;
            }
            if (countBreaks > 1) {
                return false; // More than one break means not sorted and rotated
            }
        }

        return true; // At most one break
    }
}