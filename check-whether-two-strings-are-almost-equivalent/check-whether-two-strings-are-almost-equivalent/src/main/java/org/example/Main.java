package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public boolean checkAlmostEquivalent(String word1, String word2) {
       int[] fq1 = new int[26];
       int[] fq2 = new int[26];
       for (int i = 0; i < word1.length(); i++) {
           fq1[word1.charAt(i) - 'a']++;
       }
       for (int i = 0; i < word2.length(); i++) {
           fq2[word2.charAt(i) - 'a']++;
       }
       for (int i = 0; i < 26; i++) {
           if (Math.abs( fq1[i] - fq2[i]) > 3) {
               return false;
           }
       }
       return true;
    }
}