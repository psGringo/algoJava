package org.example;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        greatestLetter("AbCdEfGhIjK");
    }

    public static String greatestLetter(String s) {
        HashSet<Character> set = new HashSet<>();
        char maxChar = Character.MIN_VALUE;
        for (char c : s.toCharArray()) {
            set.add(c);
            // if met 'e' for example, check if we have E
            if (set.contains((char) (c - 32))) {
                char upperCase = (char) (c - 32);
                maxChar = (char) Math.max((int) upperCase, (int) maxChar);

                // if met 'E' for example, check if we have e
            } else if (set.contains((char) (c + 32))) {
                char upperCase = (char) (c);
                maxChar = (char) Math.max((int) (upperCase), (int) maxChar);
            }
        }
        String res = maxChar > Character.MIN_VALUE ? new String(maxChar + "") : "";
        return res;
    }

}