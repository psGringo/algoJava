package org.example;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        minimumSumSubarray(List.of(-2, 2, -3, 1), 2, 3);
    }

    public static int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int[] numsArr = nums.stream().mapToInt(n -> n).toArray();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < numsArr.length; i++) {
            for (int j = 0; j < numsArr.length; j++) {
                int subArraySize = j - i + 1;
                if (subArraySize >= l && subArraySize <= r) {
                    int subArraySum = getSubArraySum(numsArr, i, j);
                    if (subArraySum > 0) {
                        minSum = Math.min(minSum, subArraySum);
                    }
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }

    private static int getSubArraySum(int[] nums, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += nums[k];
        }
        return sum;
    }
}