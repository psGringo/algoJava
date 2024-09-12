package org.example;


/**
 * https://leetcode.com/problems/length-of-last-word/description/
 */
public class Main {
    public static void main(String[] args) {
      int res = lengthOfLastWord("   fly me   to   the moon  ");
    }

    public static int lengthOfLastWord(String s) {
      String[] words = s.trim().split("\\s+");
      return words[words.length - 1].length();
    }

}