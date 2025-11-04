package org.example;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }

    /**
     * 2966. Divide Array Into Arrays With Max Difference
     *
     * Algorithm:
     * 1) Sort nums ascending.
     * 2) Partition into consecutive triplets: (i, i+1, i+2).
     * 3) For each triplet, check nums[i+2] - nums[i] <= k.
     *    (This implies all pairwise diffs <= k.)
     * 4) If any check fails, return empty 2D array.
     *
     * Time:  O(n log n) due to sort
     * Space: O(n) for output
     */
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int groups = n / 3;
        int[][] res = new int[groups][3];

        for (int i = 0, g = 0; i < n; i += 3, g++) {
            // max - min within the triplet
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }
            res[g][0] = nums[i];
            res[g][1] = nums[i + 1];
            res[g][2] = nums[i + 2];
        }
        return res;
    }
}