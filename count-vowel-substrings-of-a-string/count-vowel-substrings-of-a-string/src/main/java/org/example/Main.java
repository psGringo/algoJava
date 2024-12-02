package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/count-vowel-substrings-of-a-string/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public static int countVowelSubstrings(String word) {
        int targetMask = getBitMask("aeiou");
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j < word.length(); j++) {
                if (j - i < 4) {
                    continue;
                }
                if (getBitMask(word.substring(i, j + 1)) == targetMask) {
                    count++;
                };
            }
        }
        return count;
    }

//    public static int countVowelSubstrings2(String word) {
//        int targetMask = getBitMask("aeiou");
//
//        int i = 0;
//        int j = i + 4;
//
//        int count = 0;
//        // expanding window
//        while (true) {
//            if (isVowelSubstring(targetMask, word.substring(i, j + 1))) {
//                count++;
//            }
//            if (j < word.length() - 1) {
//                j++;
//            } else if (j == word.length() - 1) {
//                i++;
//            }
//
//            if (j >= word.length() - 1 && (i >= word.length() - 4)) {
//                break;
//            }
//        }
//
//        // sliding window
//        i = 0;
//        j = i + 4;
//        while (true) {
//            if (isVowelSubstring(targetMask, word.substring(i, j + 1))) {
//                count++;
//            }
//            i++;
//            j++;
//            if (j >= word.length() - 1 && (i >= word.length() - 4)) {
//                break;
//            }
//        }
//
//        return count;
//    }
//
//    private static boolean isVowelSubstring(int targetMask, String word) {
//        return targetMask == getBitMask(word);
//    }

    private static int getBitMask(String word) {
        int mask = 0;
        for (char c : word.toCharArray()) {
            mask |= (1 << (c - 'a'));
        }
        return mask;
    }
}