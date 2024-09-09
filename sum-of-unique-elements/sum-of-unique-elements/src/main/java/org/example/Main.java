package org.example;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/sum-of-unique-elements/submissions/1384657333/
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,2};
        int sum = sumOfUnique(nums);
    }

    public static int sumOfUnique(int[] nums) {
        var mapStatistics = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int count = mapStatistics.getOrDefault(nums[i], 0);
            mapStatistics.put(nums[i], ++count);
        }

        var uniqueNums = new ArrayList<Integer>();

        var iterator = mapStatistics.entrySet().iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            var entry = iterator.next();
            if (entry.getValue() == 1) {
                sum += entry.getKey();
                uniqueNums.add(entry.getKey());
            }
        }

        return sum;
    }
}