package org.example;


/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
 */
public class Main {
    public static void main(String[] args) {
        strStr("hello", "ll");
    }

    public static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (isNeedle(haystack, needle, i)) {
                    return i;
                }
            }
        }

        return -1;
    }

    private static boolean isNeedle(String haystack, String needle, int startIndex) {
        char[] maybeNeedle = new char[needle.length()];
        int j = 0;
        for (int i = startIndex; i < haystack.length() && i - startIndex < needle.length(); i++) {
            maybeNeedle[j++] = haystack.charAt(i);
        }

        return needle.equals(new String(maybeNeedle));
    }
}

