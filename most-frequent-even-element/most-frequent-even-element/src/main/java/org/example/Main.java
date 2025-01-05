package org.example;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 0x1) == 0) {

                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }

        int mostFrequent = -1;
        int maxFrequency = Integer.MIN_VALUE;
        var iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostFrequent = entry.getKey();
            } else if (entry.getValue() == maxFrequency) {
                mostFrequent = Math.min(mostFrequent, entry.getKey());
            }
        }


        return mostFrequent;
    }
}