package org.example;


/**
 * https://leetcode.com/problems/watering-plants/description/?envType=problem-list-v2&envId=vthevgcm
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     * Problem: 2079. Watering Plants
     *
     * Algorithm:
     * Imagine a row of plants positioned along a straight path at indices 0, 1, 2, ..., n−1.
     * You start at the water source (position -1) with a watering can that holds `capacity` units of water.
     * You must water each plant from left to right in order.
     *
     * Steps:
     * 1. Initialize `steps = 0` and `cur = capacity`.
     * 2. For each plant `i`:
     *      - If there is **enough water** in the can (`cur >= plants[i]`):
     *          → Move forward 1 step to plant `i`,
     *          → Water it (`cur -= plants[i]`),
     *          → Increment steps by 1.
     *      - If there is **not enough water** (`cur < plants[i]`):
     *          → Walk back to the water source (`i` steps),
     *          → Refill the can to full capacity,
     *          → Walk again to the same plant (`i` steps forward),
     *          → Total of `2 * i` extra steps,
     *          → Then perform the usual 1 step forward and water it.
     * 3. After the last plant, you do not need to return to the river.
     *
     * Complexity:
     *  - Time: O(n), because we visit each plant once.
     *  - Space: O(1), only a few integer variables are used.
     *
     * Example:
     *  plants = [2, 2, 3, 3], capacity = 5
     *
     *  Step-by-step:
     *   i=0: enough water (5 ≥ 2)
     *        → +1 step, cur=3
     *   i=1: enough water (3 ≥ 2)
     *        → +1 step, cur=1
     *   i=2: not enough (1 < 3)
     *        → back & forth (2*2=4 steps), refill (cur=5)
     *        → +1 step to plant, cur=2
     *   i=3: not enough (2 < 3)
     *        → back & forth (2*3=6 steps), refill (cur=5)
     *        → +1 step to plant, cur=2
     *
     *  Total steps = 1 + 1 + (4+1) + (6+1) = 14
     *
     * @param plants an array where plants[i] is the amount of water required for the i-th plant
     * @param capacity the maximum capacity of the watering can
     * @return the total number of steps needed to water all the plants
     */
    public int wateringPlants(int[] plants, int capacity) {
        int steps = 0;
        int cur = capacity;

        for (int i = 0; i < plants.length; i++) {
            if (cur < plants[i]) {
                steps += 2 * i;
                cur = capacity;
            }

            steps++;
            cur -= plants[i];
        }

        return steps;
    }
}