package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
    }





    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfsBacktrackingAllPermutations(nums, 0, res);
        dfsBacktrackingAllSubsets(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private static void dfsBacktrackingAllPermutations(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i); // choose
            dfsBacktrackingAllPermutations(nums, start + 1, result); // explore
            swap(nums, start, i); // un-choose (backtrack)
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void dfsBacktrackingAllSubsets(int[] nums, int index, List<Integer> prevCombination, List<List<Integer>> allCombinations) {
        List<Integer> newCombination = new ArrayList<>(prevCombination);
        newCombination.add(nums[index]);
        allCombinations.add(newCombination);

        if (index == nums.length - 1) {
            return;
        }

        dfsBacktrackingAllSubsets(nums, index + 1, prevCombination, allCombinations);
        dfsBacktrackingAllSubsets(nums, index + 1, newCombination, allCombinations);
    }


    private static void doPermute(int index, int[] nums, List<Integer> path, List<List<Integer>> result) {

        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        doPermute(index + 1, nums, path, result);
        path.add(nums[index]);
        doPermute(index + 1, nums, path, result);
        path.remove(path.size() - 1);
    }
}