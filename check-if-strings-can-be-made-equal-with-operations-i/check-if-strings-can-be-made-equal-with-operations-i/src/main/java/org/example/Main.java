package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean canBeEqual(String s1, String s2) {
        // Extract even-indexed characters and sort them
        char[] s1Even = {s1.charAt(0), s1.charAt(2)};
        char[] s2Even = {s2.charAt(0), s2.charAt(2)};
        Arrays.sort(s1Even);
        Arrays.sort(s2Even);

        // Extract odd-indexed characters and sort them
        char[] s1Odd = {s1.charAt(1), s1.charAt(3)};
        char[] s2Odd = {s2.charAt(1), s2.charAt(3)};
        Arrays.sort(s1Odd);
        Arrays.sort(s2Odd);

        // Compare sorted even and odd indexed characters
        return Arrays.equals(s1Even, s2Even) && Arrays.equals(s1Odd, s2Odd);
    }
}