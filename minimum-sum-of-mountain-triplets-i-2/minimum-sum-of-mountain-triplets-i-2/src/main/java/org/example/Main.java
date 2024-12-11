package org.example;


/**
 * https://leetcode.com/problems/minimum-sum-of-mountain-triplets-i/description/
 */
public class Main {
    public static void main(String[] args) {
        minimumSum(new int[]{8, 6, 1, 5, 3});
    }
    // 8,6,1,5,3
    // 1,3,2,4,5

    public static int minimumSum(int[] nums) {
        int n = nums.length;
        int min1[] = new int[n];
        int min2[] = new int[n];

        min1[0] = nums[0];
        min2[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            min1[i] = Math.min(min1[i - 1], nums[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            min2[i] = Math.min(min2[i + 1], nums[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < n - 1; i++) {
            if (min1[i - 1] < nums[i] && min2[i + 1] < nums[i]) {
                ans = Math.min(ans, min1[i - 1] + nums[i] + min2[i + 1]);
            }
        }

        if (ans == Integer.MAX_VALUE) return -1;
        else return ans;
    }

}