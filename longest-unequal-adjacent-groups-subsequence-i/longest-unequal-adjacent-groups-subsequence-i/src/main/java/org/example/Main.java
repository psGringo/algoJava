package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        getLongestSubsequence(new String[]{"a", "b", "c", "d"}, new int[]{1, 0, 1, 1});
    }

    public static List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);
        for (int i = 1; i < groups.length; i++) {
            if (groups[i] != groups[i - 1]) {
                result.add(words[i]);
            }
        }
        return result;
    }
}