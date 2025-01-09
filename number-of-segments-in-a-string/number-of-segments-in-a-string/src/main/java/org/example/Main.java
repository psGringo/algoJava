package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/number-of-segments-in-a-string/description/
 */
public class Main {
    public static void main(String[] args) {
        countSegments(", , , ,        a, eaefa");
    }

    public static int countSegments(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int countSegments = 0;
        String[] splitted = s.split(" ");
        int i = 0;
        while (i < splitted.length) {
            if (splitted[i].trim().length() > 0) {
                countSegments++;
            }
            i++;
        }

        return countSegments;
    }
}