package org.example;


/**
 * https://leetcode.com/problems/split-the-array/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean isPossibleToSplit(int[] nums) {
         int[] fq = new int[100];
         for (int i = 0; i < nums.length; i++) {
             fq[nums[i]]++;
         }
         for (int i = 0; i < fq.length; i++) {
             if (fq[i] > 2) {
                 return false;
             }
         }
         return true;
    }
}