package org.example;


/**
 * https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/
 */
public class Main {
    public static void main(String[] args) {
        maximumCount(new int[]{-2, -1, -1, 1, 2, 3});
    }

    public static int maximumCount(int[] nums) {
        int firstPositiveIndex = binarySearchPositive(nums);
        int firstNegativeIndex = binarySearchNegative(nums);
        int countPositive = 0;
        int countNegative = 0;
        if (firstPositiveIndex >= 0) {
            countPositive = nums.length - 1 - firstPositiveIndex + 1;
        }
        if (firstNegativeIndex >= 0) {
            countNegative = firstNegativeIndex + 1;
        }

        return Math.max(countPositive, countNegative);
    }

    private static int binarySearchPositive(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > 0) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static int binarySearchNegative(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;

            }
        }
        return hi;
    }
}