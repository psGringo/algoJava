package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-absolute-difference/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - arr[i - 1]);
            minDiff = Math.min(minDiff, diff);
        }

        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - arr[i - 1]);
            if (diff == minDiff) {
                res.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return res;
    }
}