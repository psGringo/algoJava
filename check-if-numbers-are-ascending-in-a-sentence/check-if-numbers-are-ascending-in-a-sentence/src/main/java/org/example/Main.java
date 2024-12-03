package org.example;


/**
 * https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/description/
 */
public class Main {
    public static void main(String[] args) {
        areNumbersAscending("hello world 5 x 5");
    }

    public static boolean areNumbersAscending(String s) {
        String[] words = s.split(" ");
        int first = -1;
        int second = -1;
        for (int i = 0; i < words.length; i++) {
            if (Character.isDigit(words[i].charAt(0))) {
                if (first == -1) {
                    first = Integer.parseInt(words[i]);
                } else {
                    second = Integer.parseInt(words[i]);
                }
                if (first != -1 && second != -1) {
                    if (first >= second) {
                        return false;
                    }
                    first = second;
                    second = -1;
                }
            }
        }
        return true;
    }
}