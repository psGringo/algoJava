package org.example;


/**
 * https://leetcode.com/problems/find-the-xor-of-numbers-which-appear-twice/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int duplicateNumbersXOR(int[] nums) {
        int[] frequencies = new int[51];
        for (int num : nums) {
            frequencies[num]++;
        }
        int xor = 0;
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > 1) {
                xor = xor ^ i;
            }
        }

        return xor;
    }
}