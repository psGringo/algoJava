package org.example;


/**
 * https://leetcode.com/problems/determine-if-two-events-have-conflict/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean haveConflict(String[] event1, String[] event2) {
        // Parse start and end times for both events
        int start1 = timeToMinutes(event1[0]);
        int end1 = timeToMinutes(event1[1]);
        int start2 = timeToMinutes(event2[0]);
        int end2 = timeToMinutes(event2[1]);

        // Check for overlap
        return start1 <= end2 && start2 <= end1;
    }

    // Helper function to convert "HH:MM" to minutes since midnight
    private int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}