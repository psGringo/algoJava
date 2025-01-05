package org.example;


/**
 * https://leetcode.com/problems/consecutive-characters/submissions/1498648523/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int maxPower(String s) {
        int maxCount = 1; // At least one character exists
        int currentCount = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentCount++; // Increment the current sequence count
            } else {
                maxCount = Math.max(maxCount, currentCount); // Update maxCount
                currentCount = 1; // Reset for the new character
            }
        }

        // Update maxCount for the last sequence
        maxCount = Math.max(maxCount, currentCount);

        return maxCount;
    }

}