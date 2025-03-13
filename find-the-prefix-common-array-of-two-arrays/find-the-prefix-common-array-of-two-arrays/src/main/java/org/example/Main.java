package org.example;


/**
 * https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        int count = 0;
        int[] freq = new int[n + 1];
        for (int i = 0; i < A.length; i++) {
            freq[A[i]]++;
            if (freq[A[i]] == 2) {
                count++;
            }
            freq[B[i]]++;
            if (freq[B[i]] == 2) {
                count++;
            }
            res[i] = count;
        }

        return res;
    }
}