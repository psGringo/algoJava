package org.example;


/**
 * solved in iterative and binary ways
 * https://leetcode.com/problems/find-peak-element/description/
 */
public class Main {
    public static void main(String[] args) {
        findPeakElementBinary(new int[]{6, 5, 4, 3, 2, 3, 2});
    }

    public static int findPeakElementBinary(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }
        return doFindPeakElementBinaryIterative(nums);
    }

    private static int doFindPeakElementBinaryIterative(int[] nums) {
        int start = 0;
        int end = nums.length - 1;


        while (start <= end) {
            int middle = start + (end - start) / 2;
            // terminal conditions
            if (middle == 0) {
                if (nums[middle] > nums[middle + 1]) {
                    return middle;
                }
            } else if (middle == nums.length - 1) {
                if (nums[middle] > nums[middle - 1]) {
                    return middle;
                }
            } else if (nums[middle] > nums[middle - 1] && nums[middle] > nums[middle + 1]) {
                return middle;
            }

            if (nums[middle] < nums[middle + 1]) {
                start = middle + 1;
            } else if (nums[middle] < nums[middle - 1]) {
                end = middle - 1;
            }
        }
        return -1;
    }


    private static int doFindPeakElementBinaryRecursive(int[] nums, int start, int end) {
        int middle = start + (end - start) / 2;

        // terminal conditions
        if (middle == 0) {
            if (nums[middle] > nums[middle + 1]) {
                return middle;
            }
        } else if (middle == nums.length - 1) {
            if (nums[middle] > nums[middle - 1]) {
                return middle;
            }
        } else if (nums[middle] > nums[middle - 1] && nums[middle] > nums[middle + 1]) {
            return middle;
        }

        if (nums[middle] < nums[middle + 1]) {
            return doFindPeakElementBinaryRecursive(nums, middle + 1, end);
        } else if (nums[middle] < nums[middle - 1]) {
            return doFindPeakElementBinaryRecursive(nums, start, middle - 1);
        }

        return -1;
    }


    public static int findPeakElementIterative(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }
        int i = 0;
        while (i < nums.length) {
            if (i == 0 && (nums[i] > nums[i + 1])) {
                return i;
            } else if (i == nums.length - 1 && (nums[i] > nums[i - 1])) {
                return i;
            } else if (i != 0 && i != nums.length - 1) {
                int left = i - 1;
                int middle = i;
                int right = middle + 1;
                if (nums[middle] > nums[left] && nums[middle] > nums[right]) {
                    return middle;
                }
            }
            i++;
        }
        return -1;
    }
}