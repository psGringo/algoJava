package org.example;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-equivalent-domino-pairs/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        for (int[] domino : dominoes) {
            // Normalize the domino: smaller number comes first
            int a = Math.min(domino[0], domino[1]);
            int b = Math.max(domino[0], domino[1]);

            // Use a unique hash for the pair
            int hash = a * 10 + b;

            // Update the frequency map
            int freq = freqMap.getOrDefault(hash, 0);
            count += freq; // Add the number of pairs formed with this domino
            freqMap.put(hash, freq + 1);
        }

        return count;
    }
}