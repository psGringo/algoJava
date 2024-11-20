package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/editorial/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, (x, y) -> {
            int hummingWeightX = Integer.bitCount(x);
            int hummingWeightY = Integer.bitCount(y);

            if (hummingWeightX == hummingWeightY) {
                return x - y;
            }

            return hummingWeightX - hummingWeightY;
        });
        return Arrays.stream(nums).mapToInt(i -> i).toArray();
    }
}