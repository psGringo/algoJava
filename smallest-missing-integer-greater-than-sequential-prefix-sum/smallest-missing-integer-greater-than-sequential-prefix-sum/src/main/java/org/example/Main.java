package org.example;


import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        missingInteger(new int[]{14, 9, 6, 9, 7, 9, 10, 4, 9, 9, 4, 4});
    }

    public static int missingInteger(int[] nums) {
        // find sequence
        // find missing num

        int maxPrefixSum = getPrefixSum(nums);

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // totalSum
        int missing = maxPrefixSum;
        while (set.contains(missing)) {
            missing++;
        }

        return missing;
    }

    private static int getPrefixSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int prefixSum = nums[0];
        int maxPrefixSum = prefixSum;
        if (nums.length == 1) {
            return prefixSum;
        }

        int i = 0;
        int j = i + 1;

        while (j < nums.length) {
            if (nums[j] - nums[i] == 1) {
                prefixSum += nums[j];
                maxPrefixSum = Math.max(maxPrefixSum, prefixSum);
                i++;
                j++;
            } else {
                break;
//                i++;
//                j++;
//                prefixSum = nums[i];
            }
        }

        return maxPrefixSum;
    }

}