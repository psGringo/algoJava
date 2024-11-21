package org.example;


/**
 * https://leetcode.com/problems/special-array-i/description/
 */
public class Main {
    public static void main(String[] args) {
        isArraySpecial(new int[]{2, 1, 4});
    }

    /**
     * It's been ages I heard of the word "parity".
     * for those who don't know parity it's LSB (least significant bit) rightmost bit of number which decides if number is even or odd.
     *
     * @param nums
     * @return
     */
    public static boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        for (int i = 1; i < nums.length; i++) {
            boolean isEvenOne = nums[i] % 2 == 0;
            boolean isEvenTwo = nums[i - 1] % 2 == 0;
            if (isEvenOne == isEvenTwo) {
                return false;
            }
        }
        return true;
    }
}