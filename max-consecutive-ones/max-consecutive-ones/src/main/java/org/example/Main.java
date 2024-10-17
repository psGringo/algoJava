package org.example;


/**
 * https://leetcode.com/problems/max-consecutive-ones/description/
 */
public class Main {
    public static void main(String[] args) {
        findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1});
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int max = 0;
        int count = 0;
        while (i < nums.length) {
            if (nums[i] == 1) {
                i++;
                count++;
            } else {
                if (max < count) {
                    max = count;
                }
                i++;
                count = 0;
            }
        }
        return Math.max(max, count);
    }
}