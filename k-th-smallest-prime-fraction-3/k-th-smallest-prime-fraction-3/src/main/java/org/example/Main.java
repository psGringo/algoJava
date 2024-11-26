package org.example;


/**
 * https://leetcode.com/problems/k-th-smallest-prime-fraction/description/
 */
public class Main {
    public static void main(String[] args) {
        //var res = kthSmallestPrimeFraction(new int[]{1, 29, 47}, 1);
    }

    private int resultX;
    private int resultY;
    private int countFractions;

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double lo = 0;
        double hi = 1.0;

        while (lo <= hi) {
            double mid = lo + (hi - lo) / 2;
            if (countFractions == k) {
                break;
            }
            if (g(arr, mid, k)) {
                hi = mid; // [lo, hi)
            } else {
                lo = mid;
            }
        }

        return new int[]{arr[resultX], arr[resultY]};
    }

    private boolean g(int[] arr, double mid, int targetCount) {
        double maxFraction = Double.MIN_VALUE;
        countFractions = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                double currFraction = (double) arr[i] / arr[j];
                if (currFraction < mid) {
                    countFractions++;
                    if (currFraction > maxFraction) {
                        resultX = i;
                        resultY = j;
                        maxFraction = currFraction;
                    }
                }
            }
        }
        return countFractions >= targetCount;
    }
}
