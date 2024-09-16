package org.example;


/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class Main {
    public static void main(String[] args) {
        String res = reverseWords("Let's take LeetCode contest");
    }

    public static String reverseWords(String s) {
        var splitted = s.split("\\s+");
        var sb = new StringBuilder();
        for (int i = 0; i < splitted.length; i++) {
            sb.append(reerseWord(splitted[i] + " "));
        }

        return sb.toString();
    }

    private static String reerseWord(String word) {
        var sb = new StringBuilder();
        sb.append(word);
        return sb.reverse().toString().trim();
    }

}