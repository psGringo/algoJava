package org.example;


/**
 * https://leetcode.com/problems/min-max-game/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int minMaxGame(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        while (true) {
            int[] newNums = new int[nums.length / 2];
            for (int i = 0; i < newNums.length; i++) {
                if (i % 2 == 0 && i < nums.length / 2) {
                    newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }

            if (newNums.length == 1) {
                return newNums[0];
            }

            nums = newNums;
        }
    }
}