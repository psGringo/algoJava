package org.example;


public class Main {
    public static void main(String[] args) {
        int x = mySqrt(8);
    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        return doMySqrt(x, 1, x);
    }

    private static int doMySqrt(int x, int lo, int hi) {
        if (lo > hi) {
            return hi;
        }
        int mid = lo + (hi - lo) / 2;
        if (mid > x / mid) {
            return doMySqrt(x, lo, mid - 1);
        } else if (mid < x / mid) {
            return doMySqrt(x, mid + 1, hi);
        } else {
            return mid;
        }
    }

    public static int doMySqrt(int[] arr, int x, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (lo > hi) {
            return -1;
        }

        if (arr[mid] * arr[mid] == x) {
            return arr[mid];
        } else if (arr[mid] * arr[mid] < x) {
            return doMySqrt(arr, x, mid + 1, hi);
        } else if (arr[mid] * arr[mid] > x) {
            return doMySqrt(arr, x, lo, mid - 1);
        }

        return -1;
    }

}