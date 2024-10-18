package org.example;


/**
 * https://leetcode.com/problems/find-first-palindromic-string-in-the-array/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isPalindrome(String word) {
        StringBuilder sb = new StringBuilder(word);
        return word.equals(sb.reverse().toString());
    }

}