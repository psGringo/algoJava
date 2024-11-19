package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
 */
public class Main {
    public static void main(String[] args) {
        shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4);
    }

    public static int shipWithinDays(int[] weights, int days) {
        int minCapacity = 1;
        int maxCapacity = Arrays.stream(weights).sum();

        int lo = minCapacity;
        int hi = maxCapacity;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canDoTheJob2(weights, days, mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (lo >= 1 && lo <= maxCapacity) {
            return lo;
        }

        return -1;
    }

    private static boolean canDoTheJob2(int[] weights, int days, int capacity) {
        int requiredDays = 1;  // At least one day is needed
        int currentLoad = 0;

        for (int weight : weights) {
            // Early exit if any weight exceeds the current capacity
            if (weight > capacity) return false;

            // Add weight to current day's load or start a new day if exceeded
            if (currentLoad + weight > capacity) {
                requiredDays++;
                currentLoad = weight;  // Reset current load to the new day's load
                if (requiredDays > days) return false;  // Exceeds allowed days
            } else {
                currentLoad += weight;
            }
        }
        return true;
    }


    private static boolean canDoTheJob(int[] weights, int days, int capacity) {
        int weightIndex = 0;
        int todayCapacity = capacity;
        int countDaysNeeded = 0;

        for (int i = 1; i <= days; i++) {

            // shipping
            while (weightIndex <= weights.length - 1 && todayCapacity - weights[weightIndex] >= 0) {
                todayCapacity = todayCapacity - weights[weightIndex++];
            }

            boolean isLastDay = countDaysNeeded + 1 == days;
            boolean isLastIndex = weightIndex == weights.length - 1;

            if (isLastDay && isLastIndex && todayCapacity - weights[weightIndex] < 0) {
                weightIndex--;
            }

            // next day
            todayCapacity = capacity;
            countDaysNeeded++;
        }

        if (weightIndex >= weights.length - 1) {
            return true;
        }
        return false;
    }
}