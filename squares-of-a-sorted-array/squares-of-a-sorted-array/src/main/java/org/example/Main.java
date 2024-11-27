package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/submissions/1463795671/
 */
public class Main {
    public static void main(String[] args) {
        sortedSquares(new int[]{-7, -3, 2, 3, 11});
    }

    /**
     * max will be from the left or from the right
     *
     * @param nums
     * @return
     */
    public static int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1;
        int[] res = new int[nums.length];
        int k = nums.length - 1;
        while (i <= j) {
            if (nums[i] * nums[i] >= nums[j] * nums[j]) {
                res[k--] = nums[i] * nums[i];
                i++;
            } else {
                res[k--] = nums[j] * nums[j];
                j--;
            }
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}