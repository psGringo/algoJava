package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/occurrences-after-bigram/description/
 */
public class Main {
    public static void main(String[] args) {
        findOcurrences("alice is a good girl she is a good student", "a", "good");
    }

    public static String[] findOcurrences(String text, String first, String second) {
        List<String> result = new ArrayList<>();
        String[] splitted = text.split(" ");
        for (int i = 1; i < splitted.length; i++) {
            if (splitted[i].equals(second) && splitted[i - 1].equals(first) && i < splitted.length - 1) {
                result.add(splitted[i + 1]);
            }
        }

        return result.stream().toArray(String[]::new);
    }
}