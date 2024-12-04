package org.example;


import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        isSubstringPresent("abcd");
    }

    public static boolean isSubstringPresent(String s) {
        StringBuilder sb = new StringBuilder(s);
        String reversed = sb.reverse().toString();
        for (int i = 0; i < s.length() - 1; i++) {
            String substring = s.substring(i, i + 2);
            if (reversed.contains(substring)) {
                return true;
            }
        }

        return false;
    }


}