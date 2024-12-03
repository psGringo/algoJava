package org.example;


/**
 * https://leetcode.com/problems/check-if-bitwise-or-has-trailing-zeros/description/
 */
public class Main {
    public static void main(String[] args) {
        hasTrailingZeros(new int[]{2, 2});
    }

    public static boolean hasTrailingZeros(int[] nums) {
        int countEvens = 0;
        for (int num : nums) {
            if (countEvens > 1) {
                return true;
            }
            if ((num & 0x1) == 0) {
                countEvens++;
            }
        }
        return countEvens > 1;
    }
}