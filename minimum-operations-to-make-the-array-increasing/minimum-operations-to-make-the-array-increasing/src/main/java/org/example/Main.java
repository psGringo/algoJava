package org.example;


/**
 * https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/
 */
public class Main {
    public static void main(String[] args) {
        int res = minOperations(new int[]{1, 1, 1});
    }

    public static int minOperations(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                while (nums[i] <= nums[i - 1]) {
                    nums[i]++;
                    count++;
                }
            }
        }
        return count;
    }
}