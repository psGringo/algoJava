package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public boolean makeEqual(String[] words) {

        int[] fq = new int[26];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                fq[c - 'a']++;
            }
        }

       for (int i = 0; i < 26; i++) {
           if (fq[i] % words.length != 0) {
               return false;
           }
       }

       return true;
    }
}