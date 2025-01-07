package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public String removeDigit(String number, char digit) {
        String maxResult = "";

        // Iterate through the string and remove one occurrence of digit at a time
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                // Remove the digit at the current index
                String candidate = number.substring(0, i) + number.substring(i + 1);

                // Update the max result if the candidate is greater
                if (maxResult.equals("") || candidate.compareTo(maxResult) > 0) {
                    maxResult = candidate;
                }
            }
        }

        return maxResult;
    }
}