package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        areAlmostEqual("bank", "kanb");

    }

    public static boolean areAlmostEqual(String s1, String s2) {
        int countMismatches = 0;

        List<Character> chars = new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                chars.add(s1.charAt(i));
                chars.add(s2.charAt(i));
                countMismatches++;
            }
        }

        if (countMismatches == 0) {
            return true;
        }

        if (countMismatches != 2) {
            return false;
        }


        if (chars.size() != 4) {
            return false;
        }

        if (chars.get(0) != chars.get(3)) {
            return false;
        }

        if (chars.get(1) != chars.get(2)) {
            return false;
        }

        return true;
    }
}