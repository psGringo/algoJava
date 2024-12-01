package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/count-common-words-with-one-occurrence/
 */
public class Main {
    public static void main(String[] args) {
        countWords(new String[]{"leetcode", "is", "amazing", "as", "is"}, new String[]{"amazing", "leetcode", "is"});
    }

    public static int countWords(String[] words1, String[] words2) {
        int count = 0;
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (String word : words1) {
            map1.put(word, map1.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            map2.put(word, map2.getOrDefault(word, 0) + 1);
        }
        for (var wordSet : map1.entrySet()) {
            var wordFreq1 = wordSet.getValue().intValue();
            var wordFreq2 = map2.get(wordSet.getKey());

            if (wordFreq2 != null && wordFreq2 == 1 && wordFreq1 == 1) {
                count++;
            }
        }
        return count;
    }
}