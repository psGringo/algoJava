package org.example;


public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{4, 5, 6, 7};
        int[] res = mergeTwoSortedArrays(a, b);
    }

    public static int[] mergeTwoSortedArrays(int[] A, int[] B) {
        int[] result = new int[A.length + B.length];
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                result[i] = A[i];
                i++;
            } else if (A[i] > B[j]) {
                result[i] = B[j];
                j++;
            }
        }

        int k = Math.max(i, j);
        while (i < A.length) {
            result[k++] = A[i++];
        }
        while (j < B.length) {
            result[k++] = B[j++];
        }

        return result;
    }

    public static int[] mergeThreeSortedArrays(int[] A, int[] B, int[] C) {

    }
}