package org.example;


/**
 * https://leetcode.com/problems/transformed-array/description/
 */
public class Main {
    public static void main(String[] args) {
        constructTransformedArray(new int[]{-10, -10});
    }

    public static int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                int targetIndex = (i + nums[i]) % n;
                result[i] = nums[targetIndex];
            } else if (nums[i] < 0) {
                int targetIndex = (i + nums[i]) % n;
                if (targetIndex < 0) {
                    targetIndex += n;
                }
                result[i] = nums[targetIndex];
            } else {
                result[i] = nums[i];
            }
        }



        return result;
    }
}