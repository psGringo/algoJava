package org.example;


import java.sql.Struct;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"});
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        char[] licensePlateFq = getFrequency(licensePlate);

        PriorityQueue<String> pq = new PriorityQueue<>((x, y) -> x.length() - y.length());

        for (String word : words) {
            if (checkFrequencies(licensePlateFq, word)) {
                pq.add(word);
            }
        }

        return pq.peek();
    }

    private static boolean checkFrequencies(char[] licensePlateFq, String word) {
        char[] wordFq = getFrequency(word);
        for (int i = 0; i < 130; i++) {
            if (wordFq[i] < licensePlateFq[i]) {
                return false;
            }
        }
        return true;
    }

    private static char[] getFrequency(String word) {
        char[] fq = new char[130];
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLetter(c)) {
                fq[word.charAt(i)]++;
            }
        }
        return fq;
    }
}