package org.example;


/**
 * https://leetcode.com/problems/maximum-xor-for-each-query/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] result = new int[n];

        int prefixXOR = 0;
        int maxValue = (1 << maximumBit) - 1; // 2^maximumBit - 1 (all 1s)

        // Compute prefix XOR of all elements
        for (int num : nums) {
            prefixXOR ^= num;
        }

        // Process queries in reverse order
        for (int i = 0; i < n; i++) {
            result[i] = maxValue ^ prefixXOR; // Maximum possible XOR value
            prefixXOR ^= nums[n - 1 - i]; // Remove last element from prefixXOR
        }

        return result;
    }
}