package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0; // No attacks, no poison
        }

        int totalDuration = 0;

        for (int i = 0; i < timeSeries.length -1; i++) {
            int currentAttackTime = timeSeries[i];
            int nextAttackTime = timeSeries[i + 1];
            int poisonedTime = Math.min(duration, nextAttackTime - currentAttackTime);
            totalDuration += poisonedTime;
        }

        // Add the duration for the last attack
        totalDuration += duration;

        return totalDuration;
    }
}