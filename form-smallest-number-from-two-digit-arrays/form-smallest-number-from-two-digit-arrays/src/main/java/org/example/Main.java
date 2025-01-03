package org.example;


import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/form-smallest-number-from-two-digit-arrays/description/
 */
public class Main {
    public static void main(String[] args) {
        minNumber(new int[]{6, 4, 3, 7, 2, 1, 8, 5}, new int[]{6, 8, 5, 3, 1, 7, 4, 2});
    }

    public static int minNumber(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (int num : nums2) {
            if (set.contains(num)) {
                return num;
            }
        }


        StringBuilder sb = new StringBuilder();

        if (nums1[0] < nums2[0]) {
            sb.append(nums1[0]);
            sb.append(nums2[0]);
            return Integer.parseInt(sb.toString());
        } else {
            sb.append(nums2[0]);
            sb.append(nums1[0]);
            return Integer.parseInt(sb.toString());
        }
    }
}