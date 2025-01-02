package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-palindrome/description/
 */
public class Main {
    public static void main(String[] args) {
        longestPalindrome("abccccdd");
    }

    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        var iterator = map.entrySet().iterator();

        int countOdds = 0;
        while (iterator.hasNext()) {
            var entry = iterator.next();

            if (entry.getValue() % 2 != 0) {
                countOdds++;
            }
        }

        if (countOdds < 2) {
            return s.length();
        } else {
            return s.length() - countOdds - 1;
        }
    }
}