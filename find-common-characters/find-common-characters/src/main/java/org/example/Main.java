package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/find-common-characters/description/
 */
public class Main {
    public static void main(String[] args) {
        commonChars(new String[]{"bella", "label", "roller"});
    }

    public static List<String> commonChars(String[] words) {

        // what chars did we meet?
        List<HashMap<Character, Integer>> list = new ArrayList<>();
        for (String word : words) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
            }
            list.add(map);
        }

        // TODO: optimize, iterate only by letters met, not all alphabet...
        List<String> result = new ArrayList<>();
        for (int letter = 'A'; letter <= 'z'; letter++) {
            boolean isEveryHashmapContainsLetter = true;
            while (isEveryHashmapContainsLetter) {
                for (HashMap<Character, Integer> map : list) {
                    if (!map.containsKey((char)letter) || (map.get((char)letter) == 0)) {
                        isEveryHashmapContainsLetter = false;
                    }
                }
                if (isEveryHashmapContainsLetter) {
                    result.add(String.valueOf((char)letter));
                    for (HashMap<Character, Integer> map : list) {
                        int countLetters = map.get((char)letter);
                        int newCountLetters = 0;
                        if (countLetters >= 1) {
                            newCountLetters = countLetters - 1;
                        }
                        map.put((char) letter, newCountLetters);
                    }
                }
            }
        }

        return result;
    }
}