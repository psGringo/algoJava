package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int differenceOfSum(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
          sb.append(nums[i]);
        }
        String digits = sb.toString();
        int digitsSum = 0;
        for (int i = 0; i < digits.length(); i++) {
            digitsSum += Character.digit(digits.charAt(i), 10);
        }
        return Math.abs(sum - digitsSum);
    }
}