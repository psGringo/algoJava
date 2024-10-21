package org.example;


public class Main {
    public static void main(String[] args) {
        search(new int[]{1, 3, 4, 5, 6, 7, 8, 9, 10}, 3);
    }

    public static int search(int[] nums, int target) {
        int res = binarySearch(nums, target, 0, nums.length - 1);

          return res;
    }

    private static int binarySearch(int[] nums, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= target) {
                hi = mid - 1;  // for [lo, hi] || hi = mid for [lo, hi)
            } else {
                lo = mid + 1;
            }
        }

        if (lo < nums.length && lo > 0 && nums[lo] == target) {
            return lo;
        }

        return -1; // Returns <hi + 1> if not found
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