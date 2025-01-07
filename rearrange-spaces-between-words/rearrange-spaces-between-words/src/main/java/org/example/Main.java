package org.example;


/**
 * https://leetcode.com/problems/rearrange-spaces-between-words/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public String reorderSpaces(String text) {
        // Count spaces and extract words
        int totalSpaces = 0;
        String[] words = text.trim().split("\\s+");

        for (char c : text.toCharArray()) {
            if (c == ' ') {
                totalSpaces++;
            }
        }

        int numWords = words.length;

        // Edge case: Only one word
        if (numWords == 1) {
            return words[0] + " ".repeat(totalSpaces);
        }

        // Calculate spaces between words and extra spaces
        int spacesBetween = totalSpaces / (numWords - 1);
        int extraSpaces = totalSpaces % (numWords - 1);

        // Build the result
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numWords; i++) {
            result.append(words[i]);
            if (i < numWords - 1) {
                result.append(" ".repeat(spacesBetween));
            }
        }

        // Append extra spaces
        result.append(" ".repeat(extraSpaces));

        return result.toString();
    }
}