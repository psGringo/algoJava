package org.example;


public class Main {
    public static void main(String[] args) {
        countTime("?5:00");
    }

    public static int countTime(String time) {
        String hour = time.substring(0, 2); // Extract hour part
        String minute = time.substring(3, 5); // Extract minute part

        // Count valid combinations for hours and minutes
        int validHours = countValid(hour, 23);
        int validMinutes = countValid(minute, 59);

        // Total combinations
        return validHours * validMinutes;
    }

    private static int countValid(String part, int max) {
        int count = 0;

        // Enumerate all possible two-digit combinations
        for (int i = 0; i <= max; i++) {
            String candidate = String.format("%02d", i); // Format as "XX"
            if (matches(part, candidate)) {
                count++;
            }
        }

        return count;
    }

    private static boolean matches(String pattern, String candidate) {
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) != '?' && pattern.charAt(i) != candidate.charAt(i)) {
                return false; // Mismatch found
            }
        }
        return true;
    }
}