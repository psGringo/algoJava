package org.example;


/**
 * https://leetcode.com/problems/substring-matching-pattern/description/
 */
public class Main {
    public static void main(String[] args) {
        hasMatch("aasa", "s*a");
    }

    public static boolean hasMatch(String s, String p) {
        String[] splitted = p.split("\\*", 2);
        if (splitted[0].length() == 0 && splitted[1].length() == 0) {
            return true;
        }

        if (splitted[0].length() == 0 && splitted[1].length() != 0) {
            return s.indexOf(splitted[1]) != -1;
        }

        if (splitted[1].length() == 0 && splitted[0].length() != 0) {
            return s.indexOf(splitted[0]) != -1;
        }


        int i = s.indexOf(splitted[0]);
        if (i >= 0) {
            String substring = s.substring(i + splitted[0].length());
            int j = substring.indexOf(splitted[1]);
            return j >= 0;
        }

        return false;
    }
}