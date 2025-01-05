package org.example;


/**
 * https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean checkZeroOnes(String s) {
        int maxOnes = 0, maxZeros = 0;
        int currentOnes = 0, currentZeros = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                currentOnes++;
                currentZeros = 0;
                maxOnes = Math.max(maxOnes, currentOnes);
            } else {
                currentZeros++;
                currentOnes = 0;
                maxZeros = Math.max(maxZeros, currentZeros);
            }
        }

        return maxOnes > maxZeros;
    }
}