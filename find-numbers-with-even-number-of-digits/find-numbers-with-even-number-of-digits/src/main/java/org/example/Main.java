package org.example;


/**
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int findNumbers(int[] nums) {
        int countEvenNums = 0;
        for (int num : nums) {
            int countDigits = 0;
            int tempNum = num;
            while (tempNum > 0) {
                tempNum = tempNum / 10;
                countDigits++;
            }
            if (countDigits % 2 == 0) {
                countEvenNums++;
            }
        }
        return countEvenNums;
    }
}