package org.example;


import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/description/
 */
public class Main {
    public static void main(String[] args) {
        sumCounts(List.of(1, 2, 1));
    }

    /**
     * example
     *
     * 1,2,1
     *
     *  1^2
     *  1^2 + 2^2
     *  1^2 + 2^2 + 1^2
     *
     *  2^2
     *  2^2 + 1^2...
     */
    public static int sumCounts(List<Integer> nums) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i; j < nums.size(); j++) {
                set.add(nums.get(j));
                res += set.size() * set.size();
            }
            set.clear();
        }
        return res;
    }
}