package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/magnetic-force-between-two-balls/description/
 */
public class Main {
    public static void main(String[] args) {
        int res = maxDistance(new int[]{5,4,3,2,1,1000000000}, 2);
    }

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lo = 1; // min possible distance
        int hi = position[position.length - 1] - position[0] / (m - 1); // max possible distance
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (!canPlaceBalls(position, m, mid)) { // g() function, to the right must be true...
                hi = mid - 1; // decreasing distance mid
            } else {
                lo = mid + 1; // increasing distance mid
            }
        }
        if (lo >= 0 && lo <= position[position.length - 1]) {
            return lo - 1;
        }
        return -1;
    }

    private static boolean canPlaceBalls(int[] position, int m, int mid) {
        int countPlacedBalls = 1; // placed ball to position[0]
        int lastPosition = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPosition >= mid) {
                countPlacedBalls++;
                lastPosition = position[i];
            }
            if (countPlacedBalls == m) {
                return true;
            }
        }
        return false;
    }
}