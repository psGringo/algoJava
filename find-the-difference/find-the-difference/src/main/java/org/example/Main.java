package org.example;


import java.util.*;

/**
 * https://leetcode.com/problems/find-the-difference/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public char findTheDifferenceXor(String s, String t) {
        String a = t + s;
        char result = 0;
        for (int i = 0; i < a.length(); i++) {
            result ^= a.charAt(i);
        }
        return result;
    }

    public char findTheDifferenceFrequency(String s, String t) {
        char sum = 0;
        for (int i = 0; i < t.length(); i++) {
            sum += t.charAt(i);
        }
        for (int i = 0; i < s.length(); i++) {
            sum -= s.charAt(i);
        }
        return sum;
    }


    public char findTheDifferenceHashMap(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
        }

        var iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            if (entry.getValue() > 0) {
                return entry.getKey();
            }
        }

        return '\0';
    }

}