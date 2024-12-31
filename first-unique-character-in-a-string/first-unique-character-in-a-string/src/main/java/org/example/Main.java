package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 */
public class Main {
    public static void main(String[] args) {
        firstUniqChar("leetcode");
    }

    public static int firstUniqChar(String s) {
        int[] fq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            fq[s.charAt(i) - 'a']++;
        }
        HashSet<Character> nonRepeatingChars = new HashSet<>();
        for (int i = 0; i < fq.length; i++) {
            if (fq[i] == 1) {
                nonRepeatingChars.add((char) ('a' + i));
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (nonRepeatingChars.contains(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}