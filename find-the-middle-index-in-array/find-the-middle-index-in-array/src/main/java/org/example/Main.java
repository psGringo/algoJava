package org.example;


/**
 * https://leetcode.com/problems/find-the-middle-index-in-array/description/
 */
public class Main {
    public static void main(String[] args) {
        findMiddleIndex(new int[]{2, 3, -1, 8, 4});
    }

    public static int findMiddleIndex(int[] nums) {
        int n = nums.length;

        int[] leftSum = new int[n];
        leftSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i];
        }

        int totalSum = leftSum[n - 1];

        int[] rightSum = new int[n];
        rightSum[0] = leftSum[n- 1];
        for (int i = 1; i < n; i++) {
            rightSum[i] = totalSum - leftSum[i - 1];
        }

        for (int i = 0; i < n; i++) {
            if (leftSum[i] == rightSum[i]) {
                return i;
            }
        }

        return -1;
    }
}