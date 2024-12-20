package org.example;


import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/description/
 */
public class Main {
    public static void main(String[] args) {
        minimumCost(new int[]{6, 5, 7, 9, 2, 2});
    }

    public static int minimumCost(int[] cost) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < cost.length; i++) {
            pq.add(cost[i]);
        }
        int totalCost = 0;
        while (pq.size() >= 3) {
            totalCost += pq.poll();
            totalCost += pq.poll();
            pq.poll();
        }

        while (!pq.isEmpty()) {
            totalCost += pq.poll();
        }

        return totalCost;
    }
}