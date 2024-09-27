package org.example;


import java.util.Arrays;

/**
 * 1502. Can Make Arithmetic Progression From Sequence
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }
}