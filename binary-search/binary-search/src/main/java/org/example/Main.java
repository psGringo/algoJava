package org.example;


public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int res1 = binarySearchRecursive(arr, 0, arr.length - 1, 2);
        int res2 = binarySearchIterative(arr, 0, arr.length - 1, 2);
    }

    private static int binarySearchRecursive(int[] arr, int lo, int hi, int value) {
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] < value) {
            return binarySearchRecursive(arr, mid + 1, hi, value);
        } else if (arr[mid] > value) {
            return binarySearchRecursive(arr, lo, mid - 1, value);
        }
        return -1;
    }

    private static int binarySearchIterative(int[] arr, int lo, int hi, int value) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                lo = mid + 1;
            } else if (arr[mid] > value) {
                hi = mid - 1;
            }
        }
        return -1;
    }
}