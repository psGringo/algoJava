package org.example;


public class Main {
    public static void main(String[] args) {
        minOperations(new int[]{0, 1, 1, 0, 1, 0, 0});
    }

    public static int minOperations(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < i + 3 && j < nums.length - 3; j++) {
                    if (nums[j] == 0) {
                        nums[j] = 1;
                    } else {
                        nums[j] = 0;
                    }
                }
                count++;
            }

        }

        for (int num : nums) {
            if (num == 0) {
                return -1;
            }
        }
        return count;
    }
}