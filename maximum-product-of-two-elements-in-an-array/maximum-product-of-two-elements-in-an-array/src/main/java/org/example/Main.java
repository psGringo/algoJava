package org.example;


/**
 * https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, (nums[i] - 1) * (nums[j] - 1));
            }
        }
        return max;
    }
}