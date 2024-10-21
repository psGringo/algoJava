package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] res = new int[2];
        res[0] = oneContainsInAnother(nums1, nums2);
        res[1] = oneContainsInAnother(nums2, nums1);

        return res;
    }

    private int oneContainsInAnother(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            set.add(nums2[i]);
        }
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (set.contains(nums1[i])) {
                count++;
            }
        }

        return count;
    }

}