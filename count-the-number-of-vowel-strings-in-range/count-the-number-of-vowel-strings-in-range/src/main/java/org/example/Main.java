package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/description/
 */
public class Main {
    public static void main(String[] args) {
        int res = vowelStrings(new String[]{"are", "amy", "u"}, 0, 2);
    }

    public static int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (isVowel(words[i])) {
                count++;
            }
        }
        return count;
    }

    private static boolean isVowel(String s) {
        return  (isProperChar(s.charAt(0)) && isProperChar(s.charAt(s.length() - 1)));
    }

    private static boolean isProperChar(char c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
    }
}