package org.example;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/string-matching-in-an-array/description/
 */
public class Main {
    public static void main(String[] args) {
        stringMatching(new String[]{"leetcoder", "leetcode", "od", "hamlet", "am"});
    }

    public static List<String> stringMatching(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            for (String word1 : words) {
                if (word1 != word && word1.indexOf(word) != -1) {
                    set.add(word);
                }
            }
        }

        return set.stream().toList();
    }
}