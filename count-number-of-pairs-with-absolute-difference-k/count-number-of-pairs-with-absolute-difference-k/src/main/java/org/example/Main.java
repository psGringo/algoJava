package org.example;


/**
 * https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int countKDifference(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i +1; j < nums.length; j++) {
                if (i != j && Math.abs(nums[i] - nums[j]) == k) {
                    count++;
                }
            }
        }
        return count;
    }
}