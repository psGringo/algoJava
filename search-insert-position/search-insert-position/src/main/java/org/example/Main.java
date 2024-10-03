package org.example;


/**
 * https://leetcode.com/problems/search-insert-position/description/
 */
public class Main {
    public static void main(String[] args) {
        int res = searchInsert(new int[]{1, 3, 5, 6}, 5);
    }

    public static int searchInsert(int[] nums, int target) {
        return doSearchInsert(nums, target, 0, nums.length - 1);
    }

    private static int doSearchInsert(int[] nums, int target, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (hi < lo) {
            return lo;
        }
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return doSearchInsert(nums, target, lo + 1, hi);
        } else if (nums[mid] > target) {
            return doSearchInsert(nums, target, lo, mid - 1);
        }
        return lo;
    }
}