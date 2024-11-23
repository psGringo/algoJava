package org.example;


import java.util.ArrayList;

/**
 * https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        int i = 0;
        int j = 0;
        ArrayList<int[]> result = new ArrayList<int[]>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] < nums2[j][0]) {
                result.add(nums1[i]);
                i++;
            } else if (nums2[i][0] < nums1[j][0]) {
                result.add(nums2[j]);
                j++;
            } else {
                result.add(new int[]{nums1[i][0], nums2[i][1] + nums1[j][1]});
                i++;
                j++;
            }
        }
        while (i < nums1.length) {
            result.add(nums1[i]);
            i++;
        }
        while (j < nums2.length) {
            result.add(nums2[j]);
            j++;
        }
        return result.toArray(new int[result.size()][]);
    }

}