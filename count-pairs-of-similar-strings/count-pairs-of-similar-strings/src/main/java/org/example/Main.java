package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/count-pairs-of-similar-strings/description/
 */
public class Main {
    public static void main(String[] args) {
        similarPairs(new String[]{"nba", "cba", "dba"});
    }

    public static int similarPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isSimilar(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isSimilar(String word1, String word2) {
        if (word1.equals(word2)) {
            return true;
        }
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        for (int i = 0; i < word1.length(); i++) {
            set1.add(word1.charAt(i));
        }
        for (int i = 0; i < word2.length(); i++) {
            set2.add(word2.charAt(i));
        }
        if (set1.size() != set2.size()) {
            return false;
        }
        ;
        for (char c : word2.toCharArray()) {
            if (!set1.contains(c)) {
                return false;
            }
        }
        for (char c : word1.toCharArray()) {
            if (!set2.contains(c)) {
                return false;
            }
        }
        return true;
    }
}