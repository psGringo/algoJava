package org.example;


/**
 * https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public long maximumTripletValue(int[] nums) {
        long maxProduct = 0;
        int maxVal = 0;
        int maxDiff = 0;

        for (int num : nums) {
            maxProduct = Math.max(maxProduct, (long) maxDiff * num);
            maxVal = Math.max(maxVal, num);
            maxDiff = Math.max(maxDiff, maxVal - num);
        }

        return maxProduct;
    }
}