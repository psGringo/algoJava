package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/unique-morse-code-words/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    private static String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<String>();
        for (String word : words) {
            set.add(wordToMorse(word));
        }
        return set.size();
    }

    private String wordToMorse(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            String morseChar = morse[word.charAt(i) - 'a'];
            sb.append(morseChar);
        }
        return sb.toString();
    }
}