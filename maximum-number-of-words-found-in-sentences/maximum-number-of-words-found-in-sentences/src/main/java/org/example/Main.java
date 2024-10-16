package org.example;


/**
 * 2114. Maximum Number of Words Found in Sentences
 * https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/description/
 */
public class Main {
    public static void main(String[] args) {
        String[] sentences = {
                "alice and bob love leetcode", "i think so too", "this is great thanks very much"
        };
        mostWordsFound(sentences);
    }

    public static int mostWordsFound(String[] sentences) {
        int max = 0;
        for (int i = 0; i < sentences.length; i++) {
            String[] words = sentences[i].split(" ");
            if (words.length > max) {
                max = words.length;
            }
        }
        return max;
    }
}