package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/minimize-string-length/description/
 */
public class Main {
    public static void main(String[] args) {
        minimizedStringLength("baadccab");
    }

    public static int minimizedStringLength(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set.size();
    }
}