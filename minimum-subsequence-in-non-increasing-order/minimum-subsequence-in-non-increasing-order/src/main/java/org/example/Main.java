package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     * no need for getting all subsets with backtracking
     * need 2 sums,  subseqSum = totalSum - remainingSum
     *
     * suseqLength will be minimal if iterate from the right on sorted array
     *
     * @param nums
     * @return
     */
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int subSeqSum = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            subSeqSum += nums[i];
            result.add(nums[i]);
            sum -= nums[i];

            if (subSeqSum > sum) {
                return result;
            }
        }
        return result;
    }
}