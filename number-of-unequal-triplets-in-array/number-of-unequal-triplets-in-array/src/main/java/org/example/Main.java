package org.example;


/**
 * https://leetcode.com/problems/number-of-unequal-triplets-in-array/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int unequalTriplets(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
             for (int j = i + 1; j < nums.length; j++) {
                 for (int k = j + 1; k < nums.length; k++) {
                     if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                      count++;
                     }
                 }
             }
         }
        return count;
    }
}