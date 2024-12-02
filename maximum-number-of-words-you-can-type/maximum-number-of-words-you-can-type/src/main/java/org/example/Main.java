package org.example;


/**
 * https://leetcode.com/problems/maximum-number-of-words-you-can-type/description/
 */
public class Main {
    public static void main(String[] args) {
        canBeTypedWords("leet code", "lt");
    }

    public static int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");

        int count = words.length;
        for (int i = 0; i < words.length; i++) {
            for (char c : brokenLetters.toCharArray()) {
                int mask = getBitMask(words[i]);
                int bitNum = 1 << (c - 'a');
                if (hasBit(mask, bitNum)) {
                    count--;
                    break; // this word is excluded
                }
            }
        }
        return count;
    }

    private static boolean hasBit(int mask, int bitNumber) {
        return (mask & bitNumber) == bitNumber;
    }

    private static int getBitMask(String word) {
        int mask = 0;
        for (char c : word.toCharArray()) {
            mask |= 1 << (c - 'a');
        }
        return mask;
    }
}