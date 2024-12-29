package org.example;


/**
 * https://leetcode.com/problems/find-pivot-index/
 */
public class Main {
    public static void main(String[] args) {
        pivotIndex(new int[]{-1, -1, 0, 1, 1, 0});
    }

    public static int pivotIndex(int[] nums) {
        int sumLeft = 0;
        int sumRight = 0;

        for (int i = 1; i < nums.length; i++) {
            sumRight += nums[i];
        }

        for (int i = 1; i < nums.length; i++) {
            if (sumLeft == sumRight) {
                return i - 1;
            }
            sumLeft += nums[i - 1];
            sumRight -= nums[i];
        }

        if (sumLeft == sumRight) {
            return nums.length - 1;
        }

        return -1;
    }
}