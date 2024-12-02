package org.example;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        checkDistances("aa", new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    }

    public static boolean checkDistances(String s, int[] distance) {

        int[] firstOccurenceIndex = new int[26];
        Arrays.fill(firstOccurenceIndex, -1);
        for (int i = 0; i < s.length(); i++) {
            if (firstOccurenceIndex[s.charAt(i) - 'a'] == -1) {
                firstOccurenceIndex[s.charAt(i) - 'a'] = i;
            } else {
                int dist = i - firstOccurenceIndex[s.charAt(i) - 'a'] - 1;
                if (distance[s.charAt(i) - 'a'] != dist) {
                    return false;
                }
            }
        }
        return true;
    }

}