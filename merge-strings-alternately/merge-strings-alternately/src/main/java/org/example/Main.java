package org.example;


/**
 * https://leetcode.com/problems/merge-strings-alternately/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public String mergeAlternately(String word1, String word2) {
          char[] chars1 = word1.toCharArray();
          char[] chars2 = word2.toCharArray();

          int i = 0, j = 0;
          StringBuilder sb = new StringBuilder();
          while (i < chars1.length && j < chars2.length) {
              sb.append(chars1[i]);
              sb.append(chars2[j]);
          }
          while (i < chars1.length) {
              sb.append(chars1[i]);
          }
          while (j < chars2.length) {
              sb.append(chars2[j]);
          }
          return sb.toString();
    }
}