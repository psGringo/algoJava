package org.example;

import java.util.Arrays;
import java.util.HashSet;


/**
 * https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int findMaxK(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        Arrays.sort(nums);
        for (int i = nums.length - 1; i >=0 ; i--) {
            if (set.contains(-nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }
}