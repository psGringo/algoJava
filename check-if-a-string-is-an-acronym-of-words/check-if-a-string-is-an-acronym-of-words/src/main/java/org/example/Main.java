package org.example;

import java.util.List;


/**
 * https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean isAcronym(List<String> words, String s) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word.charAt(0));
        }
        String acronym = sb.toString();
        return acronym.equals(s);
    }
}