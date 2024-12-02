package org.example;


/**
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int peakIndexInMountainArray(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < arr[mid + 1]) { // g() function
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

}