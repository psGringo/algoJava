package org.example;


import java.util.Arrays;

/**
 * find-the-distance-value-between-two-arrays
 */
public class Main {
    public static void main(String[] args) {
        int[] arr1 = {4, 5, 8};
        int[] arr2 = {10, 9, 1, 8};
        int res = findTheDistanceValue(arr1, arr2, 2);
        System.out.println(res);

        int resBiSearch = binarySearchRecursive(arr1, 5);
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int distance = 0;
        for (int value : arr1) {
            if (!isInRange(arr2, value - d, value + d)) {
                distance++;
            }
        }

        return distance;
    }


    private static boolean isInRange(int[] arr, int from, int to) {

        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= from && arr[mid] <= to) {
                return true;
            } else if (arr[mid] < from) {
                left = mid + 1;
            } else if (arr[mid] > to) {
                right = mid - 1;
            }
        }

        return false;
    }


    /**
     * this is not related to decision
     *
     *
     * @param arr
     * @param x
     * @return
     */
    private static int binarySearch(int[] arr, int x) {
        Arrays.sort(arr);

        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else if (arr[mid] > x) {
                right = mid - 1;
            }
        }

        return -1;
    }

    /**
     * this is not related to decision
     *
     * @param arr
     * @param x
     * @return
     */
    private static int binarySearchRecursive(int[] arr, int x) {
        return binarySearchRecursive2(arr, x, 0, arr.length - 1);
    }

    /**
     * this is not related to decision
     *
     * @param arr
     * @param x
     * @param low
     * @param high
     * @return
     */
    private static int binarySearchRecursive2(int[] arr, int x, int low, int high) {
        Arrays.sort(arr);

        if (low >= high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (arr[mid] == x) {
            return mid;
        } else if (arr[mid] < x) {
            int left = mid + 1;
            binarySearchRecursive2(arr, x, left, high);
        } else if (arr[mid] > x) {
            int right = mid - 1;
            binarySearchRecursive2(arr, x, right, high);
        }

        return -1;
    }


}