package org.example;


/**
 * https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    // for ex., if we have 2, 3, 5, 7, 9 nums, this is enough to shift 2 to 1 and then diff between will be even
    // so the cost is only one

    public int minCostToMoveChips(int[] position) {
        int countEvenDistances = 0;
        int countOddDistances = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                countEvenDistances++;
            } else {
                countOddDistances++;
            }
        }
        return Math.min(countEvenDistances, countOddDistances);
    }

}