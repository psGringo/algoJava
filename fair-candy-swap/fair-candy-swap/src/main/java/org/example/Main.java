package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/fair-candy-swap/description/
 */
public class Main {
    public static void main(String[] args) {
        fairCandySwap(new int[]{1, 1}, new int[]{2, 2});
    }

    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        Arrays.sort(aliceSizes);
        Arrays.sort(bobSizes);

        int aliceSum = Arrays.stream(aliceSizes).sum();
        int bobSum = Arrays.stream(bobSizes).sum();
        int bob, alice = 0;
        int res[] = new int[2];

        for (int i = 0; i < aliceSizes.length; i++) {
            alice = aliceSizes[i];
            bob = alice + (bobSum - aliceSum) / 2;
            int index = binarySearch(bobSizes, bob, 0, bobSizes.length - 1);
            if (index > -1) {
                res[0] = alice;
                res[1] = bobSizes[index];
                return res;
            }
        }

        return res;
    }

    private static int binarySearch(int[] nums, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= target) {
                hi = mid - 1;  // for [lo, hi] || hi = mid for [lo, hi)
            } else {
                lo = mid + 1;
            }
        }

        if (lo >= 0 && lo < nums.length && nums[lo] == target) {
            return lo;
        }

        return -1; // Returns <hi + 1> if not found
    }
}