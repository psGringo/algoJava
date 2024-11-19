package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/maximum-number-of-pairs-in-array/description/
 */
public class Main {
    public static void main(String[] args) {
        numberOfPairs(new int[]{1, 3, 2, 1, 3, 2, 2});
    }

    public static int[] numberOfPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int countPairs = 0;
        int countLeftover = 0;
        var iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            int rest = 0;
            countPairs += entry.getValue() / 2;
            if (entry.getValue() % 2 != 0) {
                countLeftover++;
            }
        }

        return new int[]{countPairs, countLeftover};
    }

}