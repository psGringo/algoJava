package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        for (int i = 0; i <= n - 1; i++) {
            if (nums[i] != i + 1)
                return false;
        }
        return nums[n] == n ? true : false;

//        Arrays.sort(nums);
//        int n = nums.length - 1;
//        return nums[n] == n && nums[n - 1] == n ? true : false;

//      int max = Integer.MIN_VALUE;
//        for (int num : nums) {
//            max = Math.max(max, num);
//        }
//
//        return max + 1 == nums.length;
    }
}