package org.example;


/**
 * https://leetcode.com/problems/largest-3-same-digit-number-in-string/
 */
public class Main {
    public static void main(String[] args) {

    }

    public String largestGoodInteger(String num) {
        String largest = "";

        // Iterate through the string to find substrings of length 3
        for (int i = 0; i < num.length() - 2; i++) {
            // Extract the substring of length 3
            String substring = num.substring(i, i + 3);

            // Check if all three digits are the same
            if (substring.charAt(0) == substring.charAt(1) &&
                    substring.charAt(1) == substring.charAt(2)) {
                // Update the largest if the current substring is greater
                if (largest.isEmpty() || substring.compareTo(largest) > 0) {
                    largest = substring;
                }
            }
        }

        return largest;
    }
}