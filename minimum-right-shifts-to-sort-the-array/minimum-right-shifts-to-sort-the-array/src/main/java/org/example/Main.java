package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-right-shifts-to-sort-the-array/description/
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        minimumRightShifts(List.of(2, 1, 4));
    }

    public static int minimumRightShifts(List<Integer> nums) {

        int[] numsArray = nums.stream().mapToInt(i -> i).toArray();

        int count = 0;
        while (true) {
            if (isSorted(numsArray)) {
                return count;
            }
            numsArray = rightShift(numsArray);
            count++;
            if (count > numsArray.length) {
                return -1;
            }
        }
    }

    private static int[] rightShift(int[] nums) {
        int[] res;
        res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int index = i + 1;
            if (index > nums.length - 1) {
                int diff = index - (nums.length - 1);
                res[diff - 1] = nums[i];
            } else {
                res[index] = nums[i];
            }
        }

        return res;
    }

    private static boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

}