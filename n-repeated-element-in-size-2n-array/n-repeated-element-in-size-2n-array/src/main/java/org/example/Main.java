package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/n-repeated-element-in-size-2n-array/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int repeatedNTimes(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int n = nums.length / 2;
        var iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            if (entry.getValue() == n) {
                return entry.getKey();
            }
        }

        return -1;
    }
}