package org.example;


import java.util.HashSet;
import java.util.Objects;

/**
 * https://leetcode.com/problems/find-maximum-number-of-string-pairs/description/
 */
public class Main {
    public static void main(String[] args) {
        maximumNumberOfStringPairs(new String[]{"cd", "ac", "dc", "ca", "zz"});
    }

    public static int maximumNumberOfStringPairsHashSet(String[] words) {
        HashSet<String> set = new HashSet<>();
        int count = 0;
        for (String word : words) {
            if (set.contains(reverse(word))) {
                count++;
                set.remove(word);
            } else {
                set.add(word);
            }
        }
        return count;
    }

    public static int maximumNumberOfStringPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(reverse(words[j]))) {
                    count++;
                }
            }
        }
        return count;
    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        return sb.append(s).reverse().toString();
    }
}

record WordWithIndex(String word, int index) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordWithIndex that = (WordWithIndex) o;
        return index == that.index && Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, index);
    }
}