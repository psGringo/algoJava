package org.example;


public class Main {
    public static void main(String[] args) {
        findGCD(new int[] {2,5,6,9,10});
    }

    public static int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
           min = Math.min(min, nums[i]);
           max = Math.max(max, nums[i]);
        }

        int res = 1;
        for (int i = 1; i <= min; i++) {
            if (max % i == 0 && min % i == 0) {
                res = i;
            }
        }
        return res;
    }
}