package org.example;


/**
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int maxScore(String s) {
        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                totalOnes++;
            }
        }

        int leftZeros = 0, rightOnes = totalOnes, maxScore = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }
            maxScore = Math.max(maxScore, leftZeros + rightOnes);
        }

        return maxScore;
    }
}