package org.example;


/**
 * https://leetcode.com/problems/range-sum-query-immutable/description/
 */
public class Main {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[] {0, 1, 2, 3});
        numArray.sumRange(2, 3);
    }


}

class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return nums[right];
        }
        return nums[right] - nums[left - 1];
    }
}