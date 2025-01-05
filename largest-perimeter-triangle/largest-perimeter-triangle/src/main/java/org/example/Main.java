package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-perimeter-triangle/description/
 */
public class Main {
    public static void main(String[] args) {

    }


// A valid triangle satisfies the triangle inequality: a + b > c

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            // triangle inequality
            if (nums[i -2] + nums[i - 1] > nums[i]) {
                return nums[i -2] + nums[i - 1] + nums[i];
            }
        }

        return 0;
    }
}