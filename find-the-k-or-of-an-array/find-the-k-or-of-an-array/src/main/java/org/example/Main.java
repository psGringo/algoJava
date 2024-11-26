package org.example;


import java.util.Stack;

/**
 * https://leetcode.com/problems/find-the-k-or-of-an-array/description/
 */
public class Main {
    public static void main(String[] args) {
        findKOr(new int[]{10, 8, 5, 9, 11, 6, 8}, 1);
    }

    public static int findKOr(int[] nums, int k) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            if (isBitOk(nums, i, k)) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        return Integer.parseInt(sb.reverse().toString(), 2);
    }

    private static boolean isBitOk(int[] nums, int bit, int k) {
        int count = 0;
        for (int num : nums) {
            int binaryRes = (num >> bit) & 1;
            if (binaryRes == 1) {
                count += binaryRes;
            }
        }

        return count >= k;
    }
}