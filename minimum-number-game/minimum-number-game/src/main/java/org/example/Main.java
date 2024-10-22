package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-number-game/description/
 */
public class Main {
    public static void main(String[] args) {
        numberGame(new int[] {5,4,2,3});
    }

    public static int[] numberGame(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            int Alice = nums[i];
            int Bob = nums[i + 1];
            result[i] = Bob;
            result[i + 1] = Alice;
        }
        return result;
    }
}