package org.example;


/**
 * https://leetcode.com/problems/truncate-sentence/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public String truncateSentence(String s, int k) {
        String[] truncated = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < truncated.length && i < k; i++) {
            sb.append(truncated[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}