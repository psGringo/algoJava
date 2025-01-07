package org.example;


/**
 * https://leetcode.com/problems/is-subsequence/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;

        // Traverse through both strings
        while (i < s.length() && j < t.length()) {
            // If characters match, move the pointer for s
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            // Always move the pointer for t
            j++;
        }

        // If i reached the end of s, it's a subsequence
        return i == s.length();
    }
}