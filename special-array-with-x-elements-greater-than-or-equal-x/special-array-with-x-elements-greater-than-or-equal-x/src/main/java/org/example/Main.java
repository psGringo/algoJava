package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/description/
 */
public class Main {
    public static void main(String[] args) {
        specialArray(new int[]{3, 6, 7, 7, 0});
    }

    public static int specialArray(int[] nums) {
        return binarySearch(nums);
    }

    private static int count(int[] nums, int mid) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= mid) {
                count++;
            }
        }
        return count;
    }

    /**
     * Sometimes we need exact count
     *
     * @param nums
     * @return
     */
    private static int binarySearch(int[] nums) {
        int lo = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        int hi = max;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = count(nums, mid);

            if (mid == count) {
                return mid;
            }

            if (mid > count) {
                hi = mid - 1;  // for [lo, hi] || hi = mid for [lo, hi)
            } else {
                lo = mid + 1;
            }
        }

        return -1; // Returns <hi + 1> if not found
    }

}