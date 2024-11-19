package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/find-the-xor-of-numbers-which-appear-twice/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int duplicateNumbersXOR(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> duplicates = new ArrayList<>();
        var iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            int count = entry.getValue();
            if (count > 1) {
                duplicates.add(entry.getKey());
            }
        }
        int xor = 0;
        for (int i = 0; i < duplicates.size(); i++) {
            xor ^= duplicates.get(i);
        }
        return xor;
    }
}