package org.example;


/**
 * https://leetcode.com/problems/count-prefixes-of-a-given-string/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int countPrefixes(String[] words, String s) {
         int count = 0;
         for (String word : words) {
             if (s.startsWith(word)) {
                 count++;
             }
         }
         return count;
    }
}