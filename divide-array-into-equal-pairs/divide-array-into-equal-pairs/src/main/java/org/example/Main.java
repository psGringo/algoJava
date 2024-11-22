package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public boolean divideArray(int[] nums) {
        int[] fq = new int[501];
        for (int i = 0; i < nums.length; i++) {
               fq[nums[i]]++;
        }

        for (int i = 0; i < fq.length; i++) {
            if (fq[i] % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}