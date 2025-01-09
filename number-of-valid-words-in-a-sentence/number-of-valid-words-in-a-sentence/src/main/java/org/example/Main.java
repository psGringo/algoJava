package org.example;


/**
 * https://leetcode.com/problems/number-of-valid-words-in-a-sentence/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int countValidWords(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        int validCount = 0;

        for (String word : words) {
            if (isValidWord(word)) {
                validCount++;
            }
        }

        return validCount;
    }

    private boolean isValidWord(String word) {
        int n = word.length();
        boolean hasHyphen = false;

        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);

            if (Character.isDigit(c)) {
                return false; // No digits allowed
            }

            if (c == '-') {
                if (hasHyphen || i == 0 || i == n - 1 || !Character.isLetter(word.charAt(i - 1)) || !Character.isLetter(word.charAt(i + 1))) {
                    return false; // Invalid hyphen
                }
                hasHyphen = true;
            }

            if (c == '!' || c == '.' || c == ',') {
                if (i != n - 1) {
                    return false; // Punctuation must be at the end
                }
            }
        }

        return true; // Word is valid
    }
}