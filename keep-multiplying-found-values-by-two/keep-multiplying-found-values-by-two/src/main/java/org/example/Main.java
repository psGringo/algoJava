package org.example;


/**
 * https://leetcode.com/problems/keep-multiplying-found-values-by-two/description/
 */
public class Main {
    public static void main(String[] args) {
        findFinalValue(new int[]{5, 3, 6, 1, 12}, 3);
    }

    public static int findFinalValue(int[] nums, int original) {
        int[] fq = new int[2100];
        for (int i = 0; i < nums.length; i++) {
            fq[nums[i]]++;
        }

        while (true) {
            if (fq[original] == 0) {
                return original;
            }
            original *= 2;
        }
    }
}