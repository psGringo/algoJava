package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/first-letter-to-appear-twice/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public char repeatedCharacter(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                return s.charAt(i);
            }
            set.add(s.charAt(i));
        }
        return 'a'; // anything here
    }
}