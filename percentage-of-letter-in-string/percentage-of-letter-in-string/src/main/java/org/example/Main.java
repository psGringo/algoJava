package org.example;


/**
 * https://leetcode.com/problems/percentage-of-letter-in-string/description/
 */
public class Main {
    public static void main(String[] args) {
        percentageLetter("foobar", 'o');
    }

    public static int percentageLetter(String s, char letter) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                count++;
            }
        }
        int res = (count * 100 / s.length());
        return res;
    }
}