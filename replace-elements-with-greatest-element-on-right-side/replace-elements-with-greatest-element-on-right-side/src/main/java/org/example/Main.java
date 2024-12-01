package org.example;


public class Main {
    public static void main(String[] args) {
        replaceElements(new int[]{17, 18, 5, 4, 6, 1});
    }

    public static int[] replaceElements(int[] arr) {
        int max = arr[arr.length - 1];
        int[] res = new int[arr.length];
        res[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i + 1] > max) {
                max = arr[i +1];
            }
            res[i] = max;
        }
        return res;
    }
}