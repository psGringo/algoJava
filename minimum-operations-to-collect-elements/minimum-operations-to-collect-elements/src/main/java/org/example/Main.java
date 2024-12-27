package org.example;


import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-operations-to-collect-elements/description/
 */
public class Main {
    public static void main(String[] args) {
        minOperations(List.of(3, 1, 5, 4, 2), 2);
    }


    public static int minOperations(List<Integer> nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int countOperations = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            set.add(nums.get(i));
            countOperations++;
            if (isSetIsOk(set, k)) {
                return countOperations;
            }
        }

        return -1;
    }

    private static boolean isSetIsOk(HashSet<Integer> set, int k) {
        if (set.size() >= k) {
            for (int j = 1; j <= k; j++) {
                if (!set.contains(j)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}