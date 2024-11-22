package org.example;


/**
 * https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/description/
 */
public class Main {
    public static void main(String[] args) {
        isSumEqual("acb", "cba", "cdb");
    }

    public static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return getNumericValue(firstWord) + getNumericValue(secondWord) == getNumericValue(targetWord);
    }

    private static int getNumericValue(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c - 'a');
        }
        return Integer.parseInt(sb.toString());
    }
}