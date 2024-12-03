package org.example;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/take-gifts-from-the-richest-pile/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> {
            return y - x;
        });

        for (int i = 0; i < gifts.length; i++) {
            pq.add(gifts[i]);
        }
        while (k > 0) {
            int value = pq.poll();
            pq.offer((int) Math.sqrt(value));
            k--;
        }
        int res = 0;
        while (!pq.isEmpty()) {
            res += pq.poll();
        }
        return res;
    }
}