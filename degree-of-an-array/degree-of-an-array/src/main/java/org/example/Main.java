package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/degree-of-an-array/description/
 */
public class Main {
    public static void main(String[] args) {
        findShortestSubArray(new int[]{2, 1});
    }

    public static int findShortestSubArray(int[] nums) {
        // find maxFq fq element
        // find most left and most right positions of this element i and j
        // return i - j

        int[] fq = new int[50000];
        for (int i = 0; i < nums.length; i++) {
            fq[nums[i]]++;
        }


        int maxFq = Integer.MIN_VALUE;
        for (int i = 0; i < fq.length; i++) {
            int newMax = Math.max(maxFq, fq[i]);
            if (newMax >= maxFq) {
                maxFq = newMax;
            }
        }

        if (maxFq == 1) {
            return 1;
        }

        List<Integer> mostFreqNums = new ArrayList<>();
        for (int i = 0; i < fq.length; i++) {
            if (fq[i] == maxFq) {
                mostFreqNums.add(i);
            }
        }

        Result minLengthresult = getSubArrayBorders(nums, mostFreqNums.get(0));
        if (mostFreqNums.size() > 1) {
            for (int i = 1; i < mostFreqNums.size(); i++) {
                Result result = getSubArrayBorders(nums, mostFreqNums.get(i));
                if ((result.right() - result.left()) < (minLengthresult.right() - minLengthresult.left())) {
                    minLengthresult = result;
                }
            }
        }

        return minLengthresult.right() - minLengthresult.left() + 1;
    }

    public static Result getSubArrayBorders(int[] nums, int num) {
        int left = -1;
        int right = -1;
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == num && left == -1) {
                left = i;
            }
            if (nums[j] == num && right == -1) {
                right = j;
            }
            if (left > -1 && right > -1) {
                break;
            }

            i++;
            j--;
        }

        return new Result(left, right);
    }

}

record Result(int left, int right) {
}