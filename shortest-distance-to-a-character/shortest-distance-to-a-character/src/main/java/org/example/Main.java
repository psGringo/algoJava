package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/shortest-distance-to-a-character/
 */
public class Main {
    public static void main(String[] args) {
       shortestToChar("aaba", 'b');
    }

    public static int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        Arrays.fill(result, Integer.MAX_VALUE);
        int distance = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                distance = 0;
                result[i] = 0;
                continue;
            }
            if (distance != -1) {
                result[i] = ++distance;
            }
        }

        distance = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                distance = 0;
                result[i] = 0;
                continue;
            }
            if (distance != -1) {
                result[i] = Math.min(distance + 1, result[i]);
                distance++;
            }
        }
        return result;
    }
}