package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sorting-the-sentence/description/
 */
public class Main {
    public static void main(String[] args) {
        sortSentence("is2 sentence4 This1 a3");
    }

    public static String sortSentence(String s) {
        String[] words = s.split(" ");
        List<Integer> wordOrder = new ArrayList<>();
        List<String> clearWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            char numChar = words[i].charAt(words[i].length() - 1);
            wordOrder.add(Character.digit(numChar, 10));
            clearWords.add(words[i].substring(0, words[i].length() - 1));
        }

        String[] sortedWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            sortedWords[wordOrder.get(i) - 1] = clearWords.get(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sortedWords.length; i++) {
            sb.append(sortedWords[i]);
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}