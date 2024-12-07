package org.example;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/last-stone-weight/description/
 */
public class Main {
    public static void main(String[] args) {
        lastStoneWeight(new int[]{1});
    }

    public static int lastStoneWeight(int[] stones) {

        if (stones.length == 1) {
            return stones[0];
        }

        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }

        int weightOfTheLastStone = 0;

        while (true) {
            int count = 2;
            int firstStone = -1;
            int secondStone = -1;
            while (!pq.isEmpty() && count > 0) {
                firstStone = pq.poll();
                count--;
                secondStone = pq.poll();
                count--;
            }

            if (firstStone != -1 && secondStone != -1) {
                int newStoneWeight = Math.abs(firstStone - secondStone);
                if (newStoneWeight > 0) {
                    pq.add(newStoneWeight);
                }
            }

            if (pq.size() == 1) {
                weightOfTheLastStone = pq.peek();
                break;
            }

            if (pq.isEmpty()) {
                break;
            }
        }

        return weightOfTheLastStone;
    }

}