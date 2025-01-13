package org.example;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }

    public String triangleType(int[] nums) {
        // Sort the array to simplify comparisons
        Arrays.sort(nums);

        // Check for triangle validity using the triangle inequality theorem
        if (nums[0] + nums[1] <= nums[2]) {
            return "none"; // Not a valid triangle
        }

        // Classify the triangle
        if (nums[0] == nums[2]) {
            return "equilateral"; // All sides are equal
        } else if (nums[0] == nums[1] || nums[1] == nums[2]) {
            return "isosceles"; // Exactly two sides are equal
        } else {
            return "scalene"; // All sides are different
        }
    }
}