package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/description/
 */
public class Main {
    public static void main(String[] args) {
        maximumLengthSubstring("acedc");
    }

    public static int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            map.clear();
            int currLength = 0;
            for (int j = i; j < s.length(); j++) {
                if (map.containsKey(s.charAt(j)) && map.get(s.charAt(j)) == 2) {
                    break;
                }
                currLength = j - i + 1;
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            }
            // sliding window jMax - i here
            max = Math.max(max, currLength);
        }
        return max;
    }
}