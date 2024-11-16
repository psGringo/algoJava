package org.example;


/**
 * https://leetcode.com/problems/sum-of-all-odd-length-subarrays
 */
public class Main {
    public static void main(String[] args) {

    }

    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(i - j) % 2 != 0 || (i == j)) {
                    System.out.println("%s %s".formatted(i, j));
                    int localSum = 0;
                    for (int k = i; k <= j; k++) {
                        localSum += arr[k];
                    }
                    sum += localSum;
                }
            }
        }
        return sum;
    }

}