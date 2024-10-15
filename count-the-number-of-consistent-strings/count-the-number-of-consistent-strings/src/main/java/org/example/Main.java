package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/count-the-number-of-consistent-strings/description/
 */
public class Main {
    public static void main(String[] args) {
        var words = new String[]{"n", "eeitfns", "eqqqsfs", "i", "feniqis", "lhoa", "yqyitei", "sqtn", "kug", "z", "neqqis"};
        countConsistentStrings("fstqyienx", words);
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }

        int res = words.length;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!set.contains(c)) {
                    res--;
                    break;
                }
            }
        }
        return res;
    }
}