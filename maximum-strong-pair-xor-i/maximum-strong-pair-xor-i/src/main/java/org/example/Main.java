package org.example;


/**
 * https://leetcode.com/problems/maximum-strong-pair-xor-i/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int maximumStrongPairXor(int[] nums) {
        int xor = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) <= Math.min(nums[j], nums[i])) {
                    xor = Math.max(xor, nums[i] ^ nums[j]);
                }
            }
        }
        return xor == Integer.MIN_VALUE ? 0 : xor;
    }
}