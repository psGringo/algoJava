package org.example;


import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

    }

    public String makeFancyString(String s) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 1) == s.charAt(i - 2)) {
                hashSet.add(i - 2);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!hashSet.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}