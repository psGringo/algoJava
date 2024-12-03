package org.example;


/**
 * https://leetcode.com/problems/three-consecutive-odds/description/
 */
public class Main {
    public static void main(String[] args) {
        threeConsecutiveOdds(new int[]{1, 1, 1});
    }

    public static boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] % 2 != 0 && arr[i - 1] % 2 != 0 && arr[i - 2] % 2 != 0) {
                return true;
            }
        }
        return false;
    }
}