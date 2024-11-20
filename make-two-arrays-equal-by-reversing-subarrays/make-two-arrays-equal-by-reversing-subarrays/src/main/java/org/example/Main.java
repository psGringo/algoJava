package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     * we can bubble sort arr and target using adjacent elements,
     * so just compare sorted versions
     *
     * @param target
     * @param arr
     * @return
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }

}