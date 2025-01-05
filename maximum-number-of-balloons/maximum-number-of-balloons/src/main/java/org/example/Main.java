package org.example;


/**
 * https://leetcode.com/problems/maximum-number-of-balloons/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int maxNumberOfBalloons(String text) {
        // Frequency array for letters a-z
        int[] count = new int[26];

        // Count the frequency of each character in the text
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }

        // Calculate the maximum number of "balloon" instances
        int b = count['b' - 'a'];
        int a = count['a' - 'a'];
        int l = count['l' - 'a'] / 2;
        int o = count['o' - 'a'] / 2;
        int n = count['n' - 'a'];

        // Return the minimum count
        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
}