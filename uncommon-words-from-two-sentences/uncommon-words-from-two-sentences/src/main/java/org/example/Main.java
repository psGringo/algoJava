package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/description/
 */
public class Main {
    public static void main(String[] args) {
        uncommonFromSentences("this apple is sweet", "this apple is sour");
    }

    public static String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> words1 = addToHashSet(s1);
        HashMap<String, Integer> words2 = addToHashSet(s2);
        List<String> result = new ArrayList<>();
        addWords(words1, words2, result);
        addWords(words2, words1, result);
        return result.toArray(new String[result.size()]);
    }

    private static HashMap<String, Integer> addToHashSet(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] words = s.split(" ");
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return map;
    }

    private static void addWords(HashMap<String, Integer> words1, HashMap<String, Integer> words2, List<String> uncommonWords) {
        var iterator = words1.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            if (entry.getValue() == 1) {
                String word = entry.getKey();
                if (!words2.containsKey(word)) {
                    uncommonWords.add(word);
                }
            }
        }
    }
}