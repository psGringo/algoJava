package org.example;


/**
 * https://leetcode.com/problems/sign-of-the-product-of-an-array/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int arraySign(int[] nums) {
        int countNegatives = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                countNegatives++;
            }
        }
        return (countNegatives & 1) == 1 ? -1 : 1;
    }

}