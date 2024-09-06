package org.example;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/number-of-good-pairs/description/
 */

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};

        int linearSolutionResult = numIdenticalPairsLinearSolution(nums);
        System.out.println("linear solution result is %s".formatted(linearSolutionResult));

        int squareSolutionResult = numIdenticalPairsSquareSolution(nums);
        System.out.println("square solution result %s".formatted(squareSolutionResult));

    }

    /**
     * if number was met we get previous count, else 0 to localCount
     * then increment totalCount and return it back to the hashmap
     *
     * @param nums
     * @return
     */
    public static int numIdenticalPairsLinearSolution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int totalount = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer localCount = map.getOrDefault(nums[i], 0);
            totalount += localCount; // met again
            map.put(nums[i], ++localCount);
        }

        return totalount;
    }

    /**
     * square solution
     *
     * @param nums
     * @return
     */
    public static int numIdenticalPairsSquareSolution(int[] nums) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i < j) {
                    count++;
                }
            }
        }

        return count;
    }
}