package org.example;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public int[] findErrorNums(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        var iterator = map.entrySet().iterator();
        int doubledValue = -1;
        while (iterator.hasNext()) {
            var entry = iterator.next();
            if (entry.getValue() == 2) {
                doubledValue = entry.getKey();
            }
        }

        int missingValue = -1;
        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                missingValue = i;
            }
        }

        return new int[]{doubledValue, missingValue};
    }
}