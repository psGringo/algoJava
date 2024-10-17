package org.example;


/**
 * https://leetcode.com/problems/reverse-prefix-of-word/description/
 */
public class Main {
    public static void main(String[] args) {
        reversePrefix("j", 'j');
    }

    public static String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }

        String reversed = "";
        String rest = "";
        StringBuilder sb = new StringBuilder();
        if (index < word.length() - 1) {

            sb.append(word.substring(0, index + 1));
            reversed = sb.reverse().toString();
            rest = word.substring(index + 1);
        } else {
            reversed = sb.append(word).reverse().toString();
        }

        return reversed + rest;
    }
}