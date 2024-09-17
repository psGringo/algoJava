package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/jewels-and-stones/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public static int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> jewelsCount = new HashMap<>();
        for (int i = 0; i < stones.length(); i++) {
            jewelsCount.put(stones.charAt(i), jewelsCount.getOrDefault(stones.charAt(i), 0) + 1);
        }

        int totalJewels = 0;
        for (int i = 0; i < jewels.length(); i++) {
            totalJewels += jewelsCount.getOrDefault(jewels.charAt(i), 0);
        }

        return totalJewels;
    }

}