package org.example;

/**
 * https://leetcode.com/problems/maximum-number-of-balls-in-a-box/description/
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
    }

    /**
     * two pointers approach here
     *
     * @param arr
     */
    public static void duplicateZeros(int[] arr) {
        int i = 0;
        int j = 0;
        int[] tempArray = new int[arr.length];
        while (j < arr.length) {

            if (arr[i] == 0 && i < arr.length - 1) {
                tempArray[j] = 0;
                tempArray[j++] = 0;
            } else {
                tempArray[j] = arr[i];
            }

            i++;
            j++;
        }

        System.arraycopy(tempArray, 0, arr, 0, arr.length);
    }

}