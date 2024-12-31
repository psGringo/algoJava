package org.example;


import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        numberOfSpecialChars("dDDDd");
    }

    public static int numberOfSpecialChars(String word) {
        HashSet<Character> set = new HashSet<>();

        for (char c : word.toCharArray()) {
            set.add(c);
        }

        int count = 0;
        int diff = Math.abs('a' - 'A');
        for (int i = 0; i <= 26; i++) {
            char c = (char) ((int) 'a' + i);
            if (set.contains(c) && set.contains((char) ((int) c - diff))) {
                count++;
            }
        }

        return count;
    }
}
