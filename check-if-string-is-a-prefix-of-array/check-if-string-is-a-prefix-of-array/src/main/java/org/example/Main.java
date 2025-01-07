package org.example;


/**
 * https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean isPrefixString(String s, String[] words) {

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
            if (s.equals(sb.toString())) {
                return true;
            }
        }
        return false;
    }
}