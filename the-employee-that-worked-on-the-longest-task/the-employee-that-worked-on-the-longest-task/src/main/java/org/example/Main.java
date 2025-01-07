package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public int hardestWorker(int n, int[][] logs) {
        int maxDuration = 0;
        int result = -1;
        int previousTime = 0;

        for (int[] log : logs) {
            int id = log[0];
            int currentTime = log[1];

            // Calculate task duration
            int duration = currentTime - previousTime;

            // Update the result if we find a longer duration or a tie
            if (duration > maxDuration || (duration == maxDuration && id < result)) {
                maxDuration = duration;
                result = id;
            }

            // Update the previous task time
            previousTime = currentTime;
        }

        return result;
    }
}