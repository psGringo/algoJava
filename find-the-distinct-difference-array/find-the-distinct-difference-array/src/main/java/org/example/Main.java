package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/find-the-distinct-difference-array/description/
 */
public class Main {
    public static void main(String[] args) {
        distinctDifferenceArray(new int[]{3, 2, 3, 4, 2});
    }

    public static int[] distinctDifferenceArray(int[] nums) {
        HashSet<Integer> prefix = new HashSet<>();
        HashSet<Integer> suffix = new HashSet<>();
        prefix.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            suffix.add(nums[i]);
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefix.add(nums[i]);
            suffix.clear();
            for (int j = i + 1; j < nums.length; j++) {
                suffix.add(nums[j]);
            }
            result[i] = prefix.size() - suffix.size();
        }
        return result;
    }
}