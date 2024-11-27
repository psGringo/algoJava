package org.example;


/**
 * https://leetcode.com/problems/smallest-index-with-equal-value/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int smallestEqual(int[] nums) {
       for (int i = 0; i < nums.length; i++) {
           int remainder = i % 10;
           if (remainder == nums[i]) {
               return i;
           }
       }
       return -1;
    }
}