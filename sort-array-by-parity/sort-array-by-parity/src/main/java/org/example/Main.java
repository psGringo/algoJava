package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-array-by-parity/description/
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = sortArrayByParity(new int[]{3, 1, 2, 4});
    }

    public static int[] sortArrayByParity(int[] nums) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (x, y) -> {
            return x % 2  - y % 2;
        });

        return Arrays.stream(arr).mapToInt(i -> i).toArray();
    }
}