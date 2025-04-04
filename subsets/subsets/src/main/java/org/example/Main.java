package org.example;


import java.util.*;

/**
 * https://leetcode.com/problems/subsets/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // ✅ Sort to handle duplicates
        res.add(new ArrayList<>()); // ✅ Add the empty subset
        backtracking(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void backtracking(int index, int[] nums, List<Integer> prevCombination, List<List<Integer>> allCombinations) {
        for (int i = index; i < nums.length; i++) {
            // ✅ Skip duplicates
            if (i > index && nums[i] == nums[i - 1]) continue;

            List<Integer> newCombination = new ArrayList<>(prevCombination);
            newCombination.add(nums[i]);
            allCombinations.add(newCombination);
            backtracking(i + 1, nums, newCombination, allCombinations);
        }
    }
}