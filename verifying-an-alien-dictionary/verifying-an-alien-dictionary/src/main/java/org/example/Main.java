package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary/description/
 */
public class Main {
    public static void main(String[] args) {
        isAlienSorted(new String[]{"kuvp", "q"}, "zkgwaverfimqxbnctdplsjyohu");
    }

    public static boolean isAlienSorted(String[] words, String order) {
        // if equal - continue comparing, else exit with the results...
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];

            int j = 0;
            boolean needCmpareLength = true;
            while (j < word1.length() && j < word2.length()) {
                int index1 = map.get(word1.charAt(j));
                int index2 = map.get(word2.charAt(j));
                if (index1 < index2) {
                    needCmpareLength = false;
                    break;
                }
                if (index1 > index2) {
                    return false;
                }
                j++;
            }

            if (needCmpareLength && word1.length() > word2.length()) {
                return false;
            }
        }

        return true;
    }
}