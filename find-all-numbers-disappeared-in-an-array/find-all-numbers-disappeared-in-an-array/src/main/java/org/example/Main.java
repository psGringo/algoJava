package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 */
public class Main {
    public static void main(String[] args) {
        findDisappearedNumbers(new int[]{1, 1});
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            set.add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
}