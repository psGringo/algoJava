package org.example;


/**
 * https://leetcode.com/problems/apply-operations-to-an-array/description/
 */
public class Main {
    public static void main(String[] args) {
        applyOperations(new int[]{2,1,1});
    }

    public static int[] applyOperations(int[] nums) {
        boolean isDublicates = true;
        int res[] = new int[nums.length];
        int countOperations = nums.length - 1;
        while (isDublicates && countOperations > 0) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] != 0 && nums[i] == nums[i + 1]) {
                    nums[i] *= 2;
                    nums[i + 1] = 0;
                    isDublicates = true;
                } else {
                    isDublicates = false;
                }
                countOperations--;
            }
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                res[j++] = nums[i];
            }
        }
        return res;
    }
}