package org.example;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        kLengthApart(new int[]{1, 0, 0, 1, 0, 1}, 2);
    }

    public static boolean kLengthApart(int[] nums, int k) {
        int[] onesIndexes = new int[nums.length];
        Arrays.fill(onesIndexes, -1);
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                onesIndexes[j++] = i;
            }
        }

        for (int i = 1; i < onesIndexes.length; i++) {
            if (onesIndexes[i] != -1 && onesIndexes[i - 1] != -1
                    && onesIndexes[i] - onesIndexes[i - 1] <= k) {
                return false;
            }
        }

        return true;
    }
}