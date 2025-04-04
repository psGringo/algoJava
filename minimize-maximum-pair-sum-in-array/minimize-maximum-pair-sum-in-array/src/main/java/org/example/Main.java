package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int sum = 0;
        while(i < j) {
            sum = Math.max(sum, nums[i] + nums[j]);
            i++;
            j--;
        }
        return sum;
    }
}