package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/check-if-the-number-is-fascinating/description/
 */
public class Main {
    public static void main(String[] args) {
        isFascinating(783);
    }

    public static boolean isFascinating(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        sb.append(2 * n);
        sb.append(3 * n);
        String s = sb.toString();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char[] nums = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        if (map.keySet().contains(0)) {
            return false;
        }

        for (char c : nums) {
            if (!map.keySet().contains(c) || map.get(c) > 1) {
                return false;
            }
        }
        return true;
    }
}