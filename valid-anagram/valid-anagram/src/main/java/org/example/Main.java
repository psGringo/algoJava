package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/valid-anagram/description/
 */
public class Main {
    public static void main(String[] args) {
     isAnagram("ab", "a");
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)) || map.get(s.charAt(i)) < 1) {
                return false;
            }
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        }
        return true;
    }

}