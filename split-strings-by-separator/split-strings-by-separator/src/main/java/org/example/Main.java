package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/split-strings-by-separator/description/
 */
public class Main {
    public static void main(String[] args) {
        splitWordsBySeparator(List.of("$easy$", "$problem$"), '$');
    }

    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            String[] wordSplitted = word.split("\\%s".formatted(separator));
            for (String wordSplit : wordSplitted) {
                if (!wordSplit.isEmpty()) {
                    result.add(wordSplit);
                }
            }
        }
        return result;
    }
}