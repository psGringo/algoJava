package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/description/
 */
public class Main {
    public static void main(String[] args) {
        getSneakyNumbers(new int[]{0, 1, 1, 0});
    }

    public static int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> sneakyNumbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], map.getOrDefault(i, count));
            if (count == 2) {
                sneakyNumbers.add(nums[i]);
            }
        }

        return sneakyNumbers.stream().mapToInt(i -> i).toArray();
    }

}