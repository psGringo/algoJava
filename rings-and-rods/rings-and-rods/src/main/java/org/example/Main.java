package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/rings-and-rods/description/2744.%20Find%20Maximum%20Number%20of%20String%20Pairs
 */
public class Main {
    public static void main(String[] args) {

    }


    public int countPoints(String rings) {
        HashMap<Character, Integer>[] rods = new HashMap[10];
        for (int i = 0; i < rods.length; i++) {
            rods[i] = new HashMap();
        }

        for (int i = 0; i < rings.length() - 1; i = i + 2) {
            Character color = rings.charAt(i);
            Integer rodNumber = Character.digit(rings.charAt(i +1), 10);
            rods[rodNumber].put(color, rods[rodNumber].getOrDefault(color, 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < rods.length; i++) {
            if (rods[i].containsKey('R') && rods[i].containsKey('G') && rods[i].containsKey('B')) {
                count++;
            }
        }

        return count;
    }
}