package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/count-pairs-that-form-a-complete-day-i
 */
public class Main {
    public static void main(String[] args) {

    }

    public int countCompleteDayPairsHashMap(int[] hours) {
        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        int count = 0;
        for (int hour : hours) {
            int remainder = hour % 24;
            if (remainder == 0) {
                count += remainderCount.getOrDefault(remainder, 0);
            } else {
                count += remainderCount.getOrDefault(24 - remainder, 0);
            }
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }

    public int countCompleteDayPairs(int[] hours) {
        int count = 0;
        for (int i = 0; i < hours.length; i++) {
            for (int j = i + 1; j < hours.length; j++) {
                if ((hours[i] + hours[j]) % 24 == 0 ) {
                    count++;
                }
            }
        }
        return count;
    }
}