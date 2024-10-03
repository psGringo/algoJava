package org.example;


import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/permutation-difference-between-two-strings/
 */
public class Main {
    public static void main(String[] args) {
        findPermutationDifference("abc", "bac");
    }

    public static int findPermutationDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), i);
            }
        }

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Math.abs(map.getOrDefault(s.charAt(i), 0) - i);
        }

        return sum;
    }
}