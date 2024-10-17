package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        return doSearchRecursive(nums, target, 0, nums.length - 1);
    }

    private int doSearchRecursive(int[] nums, int target, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return doSearchRecursive(nums, target, lo, mid - 1);
        } else if (nums[mid] < target) {
            return doSearchRecursive(nums, target, mid + 1, hi);
        }
        return -1;
    }

    private int doSearchIterative(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            }
        }
        return -1;
    }

}