package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-target-indices-after-sorting-array/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int targetIndex = binarySearch(nums, target);
        if (targetIndex == -1) {
            return result;
        }
        for (int i = targetIndex; i < nums.length; i++) {
            if (nums[i] == target) {
                result.add(i);
            }
        }
        return result;
    }

    private int binarySearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        if (lo >= 0 && lo < nums.length && nums[lo] == target) {
            return lo;
        }

        return -1;
    }

    private int binarySearchRecursive(int[] nums, int target) {
        return doBinarySearchRecursive(nums, target, 0, nums.length - 1);
    }

    private int doBinarySearchRecursive(int[] nums, int target, int lo, int hi) {
        if (lo >= hi) {
            if (lo >= 0 && lo < nums.length && nums[lo] == target) {
                return lo;
            }

            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] >= target) {
            return doBinarySearchRecursive(nums, target, lo, mid - 1);
        } else {
            return doBinarySearchRecursive(nums, target, mid + 1, hi);
        }
    }
}