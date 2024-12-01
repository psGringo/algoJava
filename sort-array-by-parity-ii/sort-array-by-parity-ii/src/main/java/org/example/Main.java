package org.example;


/**
 * https://leetcode.com/problems/sort-array-by-parity-ii/description/
 */
public class Main {
    public static void main(String[] args) {
        sortArrayByParityII(new int[]{4, 2, 5, 7});
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int[] result = new int[nums.length];
        var evenIndex = -2;
        var oddIndex = -1;
        for (var el : nums) {
            int index = el % 2 == 0 ? (evenIndex += 2) : (oddIndex += 2);
            result[index] = el;
        }
        return result;
    }

}