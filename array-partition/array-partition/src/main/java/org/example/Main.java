package org.example;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,4,3,2};
        int res = arrayPairSum(arr);
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            res += Math.min(nums[i], nums[i + 1]);
        }
        return res;
    }

}