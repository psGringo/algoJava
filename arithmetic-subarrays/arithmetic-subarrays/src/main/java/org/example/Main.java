package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/arithmetic-subarrays/
 */
public class Main {
    public static void main(String[] args) {
        checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5});
    }

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            res.add(isOk(nums, l[i], r[i]));
        }

        return res;
    }

    private static boolean isOk(int[] nums, int left, int right) {
        int[] subArray = Arrays.copyOfRange(nums, left, right + 1);
        Arrays.sort(subArray);

        for (int i = 1; i < subArray.length; i++) {
            if (subArray[i] - subArray[i - 1] != subArray[1] - subArray[0]) {
                return false;
            }
        }

        return true;
    }
}