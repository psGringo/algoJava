package org.example;


/**
 * https://leetcode.com/problems/goat-latin/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public String toGoatLatin(String sentence) {
        String vowels = "aeiouAEIOU";
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (vowels.indexOf(word.charAt(0)) != -1) {
                // Word starts with a vowel
                word = word + "ma";
            } else {
                // Word starts with a consonant
                word = word.substring(1) + word.charAt(0) + "ma";
            }

            // Add "a" based on the index (i + 1)
            word += "a".repeat(i + 1);

            // Update the word in the array
            words[i] = word;
        }

        // Join all transformed words into a single sentence
        return String.join(" ", words);
    }
}