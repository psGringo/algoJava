package org.example;


/**
 * https://leetcode.com/problems/find-peak-element/description/
 */
public class Main {
    public static void main(String[] args) {
        findPeakElement(new int[]{1, 10});
    }

//    public static int findPeakElementBinary(int[] nums) {
//        int middle = nums.length / 2;
//        if (nums[middle + 1] > nums[middle - 1]) {
//
//        }
//    }

    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] extNums = new int[nums.length + 2];
        for (int i = 1; i < extNums.length - 1; i++) {
            extNums[i] = nums[i - 1];
        }
        extNums[0] = Integer.MIN_VALUE;
        extNums[extNums.length - 1] = Integer.MIN_VALUE;
        int res = doFindPeakElementBinary(extNums, 0, extNums.length - 1);
        return res;
    }


    public static int doFindPeakElementBinary(int[] nums, int lo, int hi) {
        System.out.println(String.format("lo = %d, hi = %d", lo, hi));

        int mid = lo + (hi - lo) / 2;
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            return mid - 1;
        }
        if (nums[mid + 1] > nums[mid]) {
            return doFindPeakElementBinary(nums, mid + 1, hi);
        } else if (nums[mid - 1] > nums[mid]) {
            return doFindPeakElementBinary(nums, lo, mid);
        }

        return -1;
    }


    private static int doFindPeakElement(int[] nums) {
        int i = 0;
        while (i + 2 < nums.length) {
            int left = nums[i];
            int middle = nums[i + 1];
            int right = nums[i + 2];
            if (middle > left && middle > right) {
                return i + 1 - 1;
            }
            i++;
        }
        return 0;
    }

}