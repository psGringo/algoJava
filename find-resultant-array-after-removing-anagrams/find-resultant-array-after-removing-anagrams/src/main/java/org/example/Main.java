package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/description/
 */
public class Main {
    public static void main(String[] args) {
        removeAnagrams(new String[]{"yjonq", "yqnoj", "oyqjn", "nqoyj", "onjqy", "joqyn", "qynjo", "jynoq"});
    }


    public List<String> removeAnagramsStackSolution(String[] words) {
        ArrayList<String> li = new ArrayList<>();
        Stack<String> stk = new Stack<>();
        for (String s : words) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String sorteds = new String(charArr);
            if (!stk.isEmpty() && stk.peek().equals(sorteds)) {
                continue;
            } else {
                stk.push(sorteds);
                li.add(s);
            }
        }
        return li;
    }


    /**
     * my solution with frequencies
     *
     * @param words
     * @return
     */
    public static List<String> removeAnagrams(String[] words) {
        List<String> wordsList = new ArrayList<>();
        for (String word : words) {
            wordsList.add(word);
        }

        boolean hasAnagrams = false;
        while (true) {
            for (int i = 1; i < wordsList.size(); i++) {
                hasAnagrams = isAnagram(wordsList.get(i), wordsList.get(i - 1));
                if (hasAnagrams) {
                    wordsList.remove(i);
                    break;
                }
            }
            if (!hasAnagrams || wordsList.size() <= 1) {
                break;
            }
        }
        return wordsList;
    }

    private static boolean isAnagram(String word1, String word2) {
        int[] fq1 = getFrequency(word1);
        int[] fq2 = getFrequency(word2);

        return Arrays.equals(fq1, fq2);
    }

    private static int[] getFrequency(String word1) {
        int[] fq1 = new int[100];
        for (int i = 0; i < word1.length(); i++) {
            fq1[word1.charAt(i) - 'a']++;
        }
        return fq1;
    }
}