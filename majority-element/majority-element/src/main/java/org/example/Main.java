package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/majority-element
 */
public class Main {
    public static void main(String[] args) {
        majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
    }

    public static int majorityElementShortSolution(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int majorityCount = nums.length / 2;
        int count = 0;
        int res = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                count++;
                res = nums[i];
                if (count == majorityCount) {
                    return res;
                }
            } else {
                count = 0;
            }
        }

        return res;
    }
}