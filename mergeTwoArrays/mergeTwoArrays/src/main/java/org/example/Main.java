package org.example;


public class Main {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] b = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        int[] res = mergeTwoArrays(a, b);
    }

    private static int[] mergeTwoArrays(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                res[k++] = a[i++];
            } else if (a[i] > b[j]) {
                res[k++] = b[j++];
            } else if (a[i] == b[j]) {
                res[++k] = a[i++];
                res[++k] = b[j++];
            }
        }

        while (i < a.length) {
            res[k++] = a[i++];
        }
        while (j < b.length) {
            res[k++] = b[j++];
        }

        return res;
    }
}