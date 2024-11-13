package org.example;


import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        HashSet<Integer> freqSet = new HashSet<>();
        for (Integer freq : map.values()) {
            freqSet.add(freq);
        }

        return freqSet.size() == 1;
    }
}