package org.example;


/**
 * 3095. Shortest Subarray With OR at Least K I
 */
public class Main {
    public static void main(String[] args) {
        minimumSubarrayLength(new int[]{1, 10, 2, 1, 12, 9}, 3);
    }

    public static int minimumSubarrayLength(int[] nums, int k) {
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int bitwise = getOrBitWise(nums, i, j);
                if (bitwise >= k) {
                    int nextMin = Math.min(minLength, j - i + 1);
                    if (nextMin < minLength) {
                        minLength = nextMin;
                    }
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    private static int getOrBitWise(int[] nums, int i, int j) {
        int res = 0;
        for (int k = i; k <= j; k++) {
            res |= nums[k];
        }
        return res;
    }
}