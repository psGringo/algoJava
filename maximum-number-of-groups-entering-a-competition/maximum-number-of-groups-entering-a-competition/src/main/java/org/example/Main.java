package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition/description/
 */
public class Main {
    public static void main(String[] args) {
        maximumGroups(new int[]{10, 6, 12, 7, 3, 5});
    }

    public static int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        long n = grades.length;
        long lo = 1; // minimum one group
        long hi = n;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long sum = (mid * (mid + 1)) / 2; // arithmetic progression

            if (sum == n) {
                return (int) mid;
            } else if (g(n, sum)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return (int) lo - 1; // unstable here, sometimes lo, sometimes lo-1
    }

    private static boolean g(long n, long sum) {
        return sum >= n;
    }
}