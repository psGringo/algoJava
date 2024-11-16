package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-the-integer-added-to-array-i/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        return nums2[0] - nums1[0];
    }
}