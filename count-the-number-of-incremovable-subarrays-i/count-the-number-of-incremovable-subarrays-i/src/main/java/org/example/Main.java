package org.example;


/**
 * https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i/description/
 */
public class Main {
    public static void main(String[] args) {
        incremovableSubarrayCount(new int[]{8, 7, 6, 6});
    }

    public static int incremovableSubarrayCount(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int minIndex = Math.min(i, j);
                int maxIndex = Math.max(i, j);
                int[] subArray = getSubArray(nums, minIndex, maxIndex);
                if (isSubarrayStrictlyIncreasing(subArray)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isSubarrayStrictlyIncreasing(int[] nums) {
        if (nums.length == 1 || nums.length == 0) {
            return true;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                return false;
            }
        }
        return true;
    }


    private static int[] getSubArray(int[] nums, int minIndex, int maxIndex) {

        int countElementsToDelete = maxIndex - minIndex + 1;
        int res[] = new int[nums.length - countElementsToDelete];

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= minIndex && i <= maxIndex) {
                continue;
            }
            res[j++] = nums[i];
        }

        return res;
    }
}