package org.example;


public class Main {
    public static void main(String[] args) {
        moveZeroes(new int[]{2, 1});
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && i == j) {
                j++;
                continue;
            } else if (nums[i] != 0 && i != j) {
                nums[j] = nums[i];
                nums[i] = 0;
                j++;
            }
        }
    }

}