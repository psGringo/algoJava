package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/word-pattern/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        // Check for length mismatch
        if (pattern.length() != words.length) {
            return false;
        }

        // Maps for bidirectional mapping
        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // Check forward mapping
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false; // Mismatch in mapping
                }
            } else {
                charToWord.put(c, word);
            }

            // Check reverse mapping
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false; // Mismatch in reverse mapping
                }
            } else {
                wordToChar.put(word, c);
            }
        }

        return true; // Pattern matches
    }
}