package org.example;


import java.util.*;

/**
 * https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/description/
 */
public class Main {
    public static void main(String[] args) {
        findKDistantIndices(new int[]{3, 4, 9, 1, 3, 9, 5}, 9, 1);
    }

    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == key) {
                for (int i = 0; i < nums.length; i++) {
                    if (Math.abs(i - j) <= k) {
                        set.add(i);
                    }
                }
            }
        }

        set.forEach(i -> res.add(i));
        Collections.sort(res, (x, y) -> x - y);
        return res;
    }

}