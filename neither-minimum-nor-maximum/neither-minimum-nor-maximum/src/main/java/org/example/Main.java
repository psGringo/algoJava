package org.example;


/**
 * https://leetcode.com/problems/neither-minimum-nor-maximum/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int findNonMinOrMax(int[] nums) {
         int min = Integer.MAX_VALUE;
         int max = Integer.MIN_VALUE;
         for (int num : nums) {
             min = Math.min(min, num);
             max = Math.max(max, num);
         }
         for (int num : nums) {
             if (num != min && num != max) {
                 return num;
             }
         }
         return -1;
    }
}