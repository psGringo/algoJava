package org.example;


import java.util.*;

/**
 * https://leetcode.com/problems/two-out-of-three/description/
 */
public class Main {
    public static void main(String[] args) {
        twoOutOfThree(new int[]{1, 2, 2}, new int[]{4, 3, 3}, new int[]{5});
    }

    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashSet<Integer> result = new HashSet<>();

        List<Set<Integer>> sets = new ArrayList<>();
        sets.add(arrayToSet(nums1));
        sets.add(arrayToSet(nums2));
        sets.add(arrayToSet(nums3));

        HashSet<Integer> intersection01 = new HashSet<>(sets.get(0));
        intersection01.retainAll(sets.get(1));
        for (int value : intersection01) {
            result.add(value);
        }

        HashSet<Integer> intersection02 = new HashSet<>(sets.get(0));
        intersection02.retainAll(sets.get(2));
        for (int value : intersection02) {
            result.add(value);
        }

        HashSet<Integer> intersection12 = new HashSet<>(sets.get(1));
        intersection12.retainAll(sets.get(2));
        for (int value : intersection12) {
            result.add(value);
        }

        return result.stream().toList();
    }

    private static Set<Integer> arrayToSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set;
    }
}