package org.example;


/**
 * https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/description/
 */
public class Main {
    public static void main(String[] args) {
        countSubarrays(new int[]{-1, -4, -1, 4});
    }

    public static int countSubarrays(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j - i == 2 && nums[i] + nums[j] == nums[j - 1] * 1.0 / 2) {
                    count++;
                }
            }
        }
        return count;
    }
}