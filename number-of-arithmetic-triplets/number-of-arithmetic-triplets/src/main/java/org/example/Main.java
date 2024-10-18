package org.example;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-arithmetic-triplets/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        Set<String> unique = new HashSet<String>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if (i < j && j < k && nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) {
                        int[] chars = {i, j, k};
                        Arrays.sort(chars);
                        if (!unique.contains(String.valueOf(chars))) {
                            unique.add(String.valueOf(chars));
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}