package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/
 */
public class Main {
    public static void main(String[] args) {
        answerQueries(new int[]{736411,184882,914641,37925,214915}, new int[]{331244,273144,118983,118252,305688,718089,665450});
    }

    public static int[] answerQueries(int[] nums, int[] queries) {
        // cumulative sorted array
        Arrays.sort(nums);
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = binarySearch(prefixSum, queries[i]);

            if (index >= 0) {
                int count = index + 1;
                ans[i] = count;
            } else {
                ans[i] = 0;
            }

        }
        return ans;
    }

    /**
     * return lo -1 here
     *
     * @param prefixSum
     * @param target
     * @return
     */
    private static int binarySearch(int[] prefixSum, int target) {
        int lo = 0;
        int hi = prefixSum.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (prefixSum[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (lo - 1 >= 0 && lo - 1 < prefixSum.length && prefixSum[lo - 1] <= target) {
            return lo - 1;
        }

        return -1;
    }
}