package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int count(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= num) {
                count++;
            }
        }
        return count;
    }

    private int binarySearch(int[] nums, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = count(nums, mid);
            if (count <= mid) {
                hi = mid - 1;  // for [lo, hi] || hi = mid for [lo, hi)
            } else {
                lo = mid + 1;
            }
        }

        if (lo > 0 && lo < nums.length) {
            return lo;
        }

        return -1; // Returns <hi + 1> if not found
    }


}