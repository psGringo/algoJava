package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public int buttonWithLongestTime(int[][] events) {
        int maxTime = 0;
        int buttonIndex = events[0][0];
        int prevTime = 0;

        for (int[] event : events) {
            int index = event[0];
            int time = event[1];
            int duration = time - prevTime;

            // Update maxTime and buttonIndex if needed
            if (duration > maxTime || (duration == maxTime && index < buttonIndex)) {
                maxTime = duration;
                buttonIndex = index;
            }

            // Update prevTime
            prevTime = time;
        }

        return buttonIndex;
    }

}