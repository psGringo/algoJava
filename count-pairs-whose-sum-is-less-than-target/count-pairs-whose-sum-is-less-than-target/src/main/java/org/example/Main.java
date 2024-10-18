package org.example;


import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int countPairs(List<Integer> nums, int target) {
        Integer[] intsArr = nums.toArray(new Integer[nums.size()]);
        int count = 0;
        for (int i = 0; i < intsArr.length; i++) {
            for (int j = i + 1; j < intsArr.length; j++) {
                if (i < j && intsArr[i] + intsArr[j] < target) {
                    count++;
                }
            }
        }
        return count;
    }
}