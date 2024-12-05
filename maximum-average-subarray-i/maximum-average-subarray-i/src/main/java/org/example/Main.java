package org.example;


public class Main {
    public static void main(String[] args) {
        findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4);
    }

    public static double findMaxAverage(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int i = 0;
        int j = k - 1;
        double maxSum = Integer.MIN_VALUE;
        while (j < nums.length) {
            maxSum = Math.max(maxSum, getMaxSum(nums, i, j));
            i++;
            j++;
        }
        return maxSum * 1.0 / k;
    }

    private static int getSum(int[] nums, int[] prefixSums, int i, int j) {
        return prefixSums[j] - prefixSums[i] + nums[i];
    }


    private static int getMaxSum(int[] nums, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += nums[k];
        }
        return sum;
    }
}