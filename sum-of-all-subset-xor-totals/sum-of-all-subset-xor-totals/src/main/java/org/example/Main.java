package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/
 */
public class Main {
    public static void main(String[] args) {
       int res = subsetXORSum(new int[]{5, 1, 6});
    }

    public static int subsetXORSum(int[] nums) {
        List<List<Integer>> combinations = new ArrayList<>();
        dfsBacktracking(nums, 0, new ArrayList<>(), combinations);
        int xorSum = 0;

        for (List<Integer> combination : combinations) {
            int xor = 0;
            for (int i = 0; i < combination.size(); i++) {
                xor ^= combination.get(i).intValue();
            }
            xorSum += xor;
        }

        return xorSum;
    }


    private static void dfsBacktracking(int[] nums, int currIndex, List<Integer> prevCombination, List<List<Integer>> allCombinations) {

        List<Integer> combinationWithCurrNumber = new ArrayList<>(prevCombination);
        combinationWithCurrNumber.add(nums[currIndex]);
        allCombinations.add(combinationWithCurrNumber);

        if (currIndex == nums.length - 1) {
            return;
        }

        dfsBacktracking(nums, currIndex +1, combinationWithCurrNumber, allCombinations);
        dfsBacktracking(nums, currIndex +1, prevCombination, allCombinations);
    }

}