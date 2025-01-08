package org.example;


/**
 * https://leetcode.com/problems/make-three-strings-equal/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int findMinimumOperations(String s1, String s2, String s3) {
        int totalLength = s1.length() + s2.length() + s3.length();
        int minLength = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        int i = 0;

        // Find the length of the common prefix
        while (i < minLength && s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) {
            i++;
        }

        // If no common prefix, return -1
        if (i == 0) {
            return -1;
        }

        // Calculate the minimum number of operations
        return totalLength - 3 * i;
    }
}