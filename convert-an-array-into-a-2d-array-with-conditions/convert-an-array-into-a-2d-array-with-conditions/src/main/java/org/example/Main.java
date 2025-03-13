package org.example;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
 */
public class Main {
    public static void main(String[] args) {
        findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1});
    }


    /**
     * Key Optimizations
     * ✅ Use int[] freq (Array) instead of HashMap for faster lookups.
     * ✅ Directly fill lists in a single pass (No Set, No Map, No Heap).
     * ✅ Eliminate redundant loops and iterations.
     *
     */
    public static List<List<Integer>> findMatrix(int[] nums) {
        int[] freq = new int[202]; // Since 1 <= nums[i] <= 200
        int maxFreq = 0; // Track the maximum frequency of any number

        for (int num : nums) {
            freq[num]++;
            maxFreq = Math.max(maxFreq, freq[num]);
        }

        // Create result list with exact required size (avoids resizing overhead)
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < maxFreq; i++) {
            res.add(new ArrayList<>());
        }

        // Distribute elements into lists
        for (int num = 1; num <= 200; num++) {
            int count = freq[num];
            for (int i = 0; i < count; i++) {
                res.get(i).add(num);
            }
        }

        return res;
    }


    public static List<List<Integer>> findMatrix3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int[]  fq = new int[202];
        for (int num : nums) {
            fq[num]++;
        }

        HashSet<Integer> set = new HashSet<>();

        while (true) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < fq.length; i++) {
                if (fq[i] > 0 && !set.contains(i)) {
                    list.add(i);
                    set.add(i);
                    fq[i]--;
                }
            }
            if (list.size() == 0) {
                break;
            }
            set.clear();
            res.add(list);
        }
        return res;
    }


    public static List<List<Integer>> findMatrix2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> visitedIndxes = new HashSet<>();
        while (visitedIndxes.size() < nums.length) {
            res.add(getNums2(nums, visitedIndxes));
        }
        return res;
    }

    private static List<Integer> getNums2(int[] nums, HashSet<Integer> visitedIndexes) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> setCurrentRow = new HashSet<>();
        List<Integer> rest = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!visitedIndexes.contains(i) && !setCurrentRow.contains(nums[i])) {
                setCurrentRow.add(nums[i]);
                result.add(nums[i]);
                visitedIndexes.add(i);
            }
        }

        return result;
    }

}