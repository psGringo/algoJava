package org.example;


/**
 * https://leetcode.com/problems/valid-mountain-array/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false; // Too short to form a mountain
        }

        int i = 0;

        // Climb up
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // Peak cannot be the first or last element
        if (i == 0 || i == n - 1) {
            return false;
        }

        // Climb down
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        // Check if we reached the end of the array
        return i == n - 1;
    }


}