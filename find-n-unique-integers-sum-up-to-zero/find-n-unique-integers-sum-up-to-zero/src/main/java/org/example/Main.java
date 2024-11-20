package org.example;


/**
 * https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description/
 */
public class Main {
    public static void main(String[] args) {
        sumZero(4);
    }

    public static int[] sumZero(int n) {
        boolean isEven = n % 2 == 0;
        int[] arr = new int[n];
        int value = - n / 2; // start value
        for (int i = 0; i < n; i++) {
            arr[i] = value;
            value++;
            // skip zero if even
            if (isEven && value == 0) {
                value = 1;
            }
        }

       return arr;
    }
}