package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/last-visited-integers/description/
 */
public class Main {
    public static void main(String[] args) {
        lastVisitedIntegers(new int[]{1, 2, -1, -1, -1});
    }

    public static List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> seen = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        List<Integer> minusOnes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                seen.add(0, nums[i]);
            } else {
                // only -1 here
                if (i > 0 && nums[i - 1] == -1) {
                    minusOnes.add(nums[i]);
                } else {
                    minusOnes.clear();
                    minusOnes.add(nums[i]);
                }

                int k = minusOnes.size();
                if (k <= seen.size()) {
                    ans.add(seen.get(k - 1));
                } else {
                    ans.add(-1);
                }
            }
        }

        return ans;
    }
}