package org.example;


import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        mostFrequent(new int[]{2, 2, 2, 2, 3}, 2);
    }

    public static int mostFrequent(int[] nums, int key) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                map.put(nums[i + 1], map.getOrDefault(nums[i + 1], 0) + 1);
            }
        }

        var iterator = map.entrySet().iterator();
        int max = Integer.MIN_VALUE;
        int maxKey = -1;
        while (iterator.hasNext()) {
            var entry = iterator.next();
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
}