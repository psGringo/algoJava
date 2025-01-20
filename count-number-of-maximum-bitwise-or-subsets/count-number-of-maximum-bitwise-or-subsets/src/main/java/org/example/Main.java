package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        countMaxOrSubsets(new int[]{2, 2, 2});
    }

    // 1, 2, 3

    public static int countMaxOrSubsets(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();
        dfsBacktracking(nums, 0, combination, subsets);

        for (List<Integer> subset : subsets) {
            int or = 0;
            for (int num : subset) {
                or = or | num;
            }
            map.put(or, map.getOrDefault(or, 0) + 1);
        }


        int max = Integer.MIN_VALUE;
        var iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            max = Math.max(max, entry.getValue());
        }

        return max;
    }


    private static void dfsBacktracking(int[] nums, int currIndex, List<Integer> prevCombination, List<List<Integer>> allCombinations) {

        List<Integer> combinationWithCurrNumber = new ArrayList<>(prevCombination);
        combinationWithCurrNumber.add(nums[currIndex]);
        allCombinations.add(combinationWithCurrNumber);

        if (currIndex == nums.length - 1) {
            return;
        }

        dfsBacktracking(nums, currIndex + 1, combinationWithCurrNumber, allCombinations);
        dfsBacktracking(nums, currIndex + 1, prevCombination, allCombinations);
    }

}
