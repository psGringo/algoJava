package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/mean-of-array-after-removing-some-elements/description/
 */
public class Main {
    public static void main(String[] args) {
        trimMean(new int[]{6, 0, 7, 0, 7, 5, 7, 8, 3, 4, 0, 7, 8, 1, 6, 8, 1, 1, 2, 4, 8, 1, 9, 5, 4, 3, 8, 5, 10, 8, 6, 6, 1, 0, 6, 10, 8, 2, 3, 4});
    }

    public static double trimMean(int[] arr) {
        Arrays.sort(arr);
        double countToDelete = (double) (arr.length * 0.05);
        double sum = 0;
        int i = (int) countToDelete;
        int j = (int) (arr.length - countToDelete);
        double n = arr.length - countToDelete * 2;
        for (int k = i; k < j; k++) {
            sum += arr[k];
        }
        return (double) sum * 1.0 / (double) (n);
    }
}