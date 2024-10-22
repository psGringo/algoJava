package org.example;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *  https://leetcode.com/problems/find-the-difference-of-two-arrays/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(doFindDifference(nums1, nums2));
        res.add(doFindDifference(nums2, nums1));
        return res;
    }

    private List<Integer> doFindDifference(int[] nums1, int[] nums2) {
        List<Integer> difference = new ArrayList<>();
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < nums2.length; i++) {
            set.add(nums2[i]);
        }
        HashSet<Integer> resultSet = new HashSet();
        for (int i = 0; i < nums1.length; i++) {
            if (!set.contains(nums1[i]) && !resultSet.contains(nums1[i])) {
                resultSet.add(nums1[i]);
                difference.add(nums1[i]);
            }
        }
        return difference;
    }

}