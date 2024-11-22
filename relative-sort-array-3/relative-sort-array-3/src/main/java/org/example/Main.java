package org.example;


/**
 * https://leetcode.com/problems/relative-sort-array/description/
 */
public class Main {
    public static void main(String[] args) {
        relativeSortArray(new int[]{2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31}, new int[]{2, 42, 38, 0, 43, 21});
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] fq = new int[1000 + 1];
        for (int i = 0; i < arr1.length; i++) {
            fq[arr1[i]]++;
        }

        int idx = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (fq[arr2[i]] > 0) {
                arr1[idx++] = arr2[i];
                fq[arr2[i]]--;
            }
        }

        for (int i = 0; i < 1001; i++) {
            while (fq[i] > 0) {
                arr1[idx++] = i;
                fq[i]--;
            }
        }

        return arr1;
    }

}