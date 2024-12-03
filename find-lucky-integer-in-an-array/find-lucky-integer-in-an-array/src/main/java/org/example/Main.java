package org.example;


/**
 * https://leetcode.com/problems/find-lucky-integer-in-an-array/description/
 */
public class Main {
    public static void main(String[] args) {
        findLucky(new int[]{2,2,2,3,3});
    }

    public static int findLucky(int[] arr) {
        int[] fq = new int[502];
        for (int i = 0; i < arr.length; i++) {
            fq[arr[i]]++;
        }
        for (int i = 501; i >= 0; i--) {
            if (fq[i] == i && i != 0) {
                return i;
            }
        }
        return -1;
    }
}