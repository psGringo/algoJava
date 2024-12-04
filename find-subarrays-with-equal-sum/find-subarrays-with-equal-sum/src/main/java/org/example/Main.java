package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/find-subarrays-with-equal-sum/description/
 */
public class Main {
    public static void main(String[] args) {
        findSubarrays(new int[]{1, 2, 3, 4, 5});
    }

    public static boolean findSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j - i == 1) {
                    int sum = 0;
                    for (int k = i; k <= j; k++) {
                        sum += nums[k];
                    }
                    if (set.contains(sum)) {
                        return true;
                    }
                    set.add(sum);
                }
            }
        }
        return false;
    }
}