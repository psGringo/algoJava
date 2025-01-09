package org.example;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-word/
 */
public class Main {
    public static void main(String[] args) {
        isValid("Ya$");
    }

    public static boolean isValid(String word) {
        // Check if the word has at least 3 characters
        if (word.length() < 3) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        // Define a set of vowel characters for quick lookup
        Set<Character> vowels = new HashSet<>(Arrays.asList(
                'a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U'
        ));

        // Iterate through each character in the word
        for (char c : word.toCharArray()) {
            // Check if the character is a digit or letter
            if (!Character.isLetterOrDigit(c)) {
                return false; // Invalid character found
            }

            // Check if the character is a vowel
            if (vowels.contains(c)) {
                hasVowel = true;
            } else if (Character.isLetter(c)) {
                // If it's a letter and not a vowel, it's a consonant
                hasConsonant = true;
            }
        }

        // Return true only if both a vowel and a consonant are present
        return hasVowel && hasConsonant;
    }
}