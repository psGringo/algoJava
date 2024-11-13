package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/count-elements-with-maximum-frequency/description/
 */
public class Main {
    public static void main(String[] args) {
        maxFrequencyElements(new int[]{15});
    }

    public static int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Integer maxFrequency = 0;
        for (int values : map.values()) {
            maxFrequency = Math.max(maxFrequency, values);
        }

        int res = 0;
        for (int value : map.values()) {
            if (value == maxFrequency) {
                res+=value;
            }
        }

        return res;
    }
}