package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-substring-between-two-equal-characters/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int maxLengthBetweenEqualCharacters(String s) {
        int[] firstPositions = new int[26];
        Arrays.fill(firstPositions, -1);
        int maxDistance = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (firstPositions[s.charAt(i) - 'a'] == -1) {
                firstPositions[s.charAt(i) - 'a'] = i;
            } else {
                maxDistance = Math.max(maxDistance, i - firstPositions[s.charAt(i) - 'a'] - 1);
            }
        }
        return maxDistance == Integer.MIN_VALUE ? -1 : maxDistance;
    }
}