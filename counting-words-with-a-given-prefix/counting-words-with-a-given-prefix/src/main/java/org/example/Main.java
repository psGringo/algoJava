package org.example;


/**
 * https://leetcode.com/problems/counting-words-with-a-given-prefix/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
}