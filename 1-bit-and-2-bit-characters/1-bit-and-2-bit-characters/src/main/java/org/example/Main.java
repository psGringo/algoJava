package org.example;


/**
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        int n = bits.length;

        while (i < n - 1) {
            if (bits[i] == 1) {
                i += 2; // Skip the next bit for 2-bit character
            } else {
                i += 1; // Move to the next bit for 1-bit character
            }
        }

        // If we stopped at the last bit, it is a 1-bit character
        return i == n - 1;
    }
}