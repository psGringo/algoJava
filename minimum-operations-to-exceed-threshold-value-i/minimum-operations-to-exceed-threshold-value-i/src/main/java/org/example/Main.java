package org.example;


/**
 * https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int minOperations(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
           if (nums[i] < k) {
               count++;
           }
       }
        return count;
    }
}