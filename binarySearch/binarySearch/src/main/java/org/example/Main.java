package org.example;


public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int res1 = doBinarySearchRecursive(arr, 0, arr.length - 1, 2);
        int res2 = doBinarySearchIterative(arr, 0, arr.length - 1, 11);
    }

    private static int doBinarySearchRecursive(int[] arr, int lo, int hi, int target) {
        int middle = lo + (hi - lo) / 2;
        if (arr[middle] == target) {
            return middle;
        }
        if (arr[middle] < target) {
            return doBinarySearchRecursive(arr, lo, middle + 1, target);
        } else if (arr[middle] > target) {
            return doBinarySearchRecursive(arr, lo, middle - 1, target);
        }
        return -1;
    }


    private static int doBinarySearchIterative(int[] arr, int lo, int hi, int target) {
        while (lo <= hi) {
            int middle = lo + (hi - lo) / 2;
            if (arr[middle] == target) {
                return middle;
            }
            if (arr[middle] < target) {
                lo = middle + 1;
            } else if (arr[middle] > target) {
                hi = middle - 1;
            }

        }
        return -1;
    }

}