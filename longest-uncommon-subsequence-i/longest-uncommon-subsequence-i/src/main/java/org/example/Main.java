package org.example;



public class Main {
    public static void main(String[] args) {

    }

    /**
     * https://leetcode.com/problems/longest-uncommon-subsequence-i/
     *
     * @param a
     * @param b
     * @return
     */
    public int findLUSlength(String a, String b) {
        // If the strings are equal, no uncommon subsequence exists
        if (a.equals(b)) {
            return -1;
        }

        // Otherwise, the longer string itself is the longest uncommon subsequence
        return Math.max(a.length(), b.length());
    }
}