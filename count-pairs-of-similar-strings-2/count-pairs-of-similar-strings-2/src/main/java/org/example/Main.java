package org.example;


/**
 * https://leetcode.com/problems/count-pairs-of-similar-strings/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int similarPairs(String[] words) {
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            masks[i] = getMask(words[i]);
        }

        int countSimilar = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (masks[i] == masks[j]) {
                    countSimilar++;
                }
            }
        }
        return countSimilar;
    }

    private int getMask(String s) {
        int mask = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            mask |= 1 << (s.charAt(i) - 'a');
        }
        return mask;
    }
}