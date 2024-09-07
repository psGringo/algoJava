package org.example;


/**
 * https://leetcode.com/problems/concatenation-of-array/description/
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] ans = getConcatenation(nums);
    }

    public static int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }

        return ans;
    }
}