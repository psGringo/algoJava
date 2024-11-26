package org.example;


import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) ->
                y - x
        );

        pq.offer(5000);
        pq.offer(2000);
        pq.offer(1000);
        pq.offer(5000);
        pq.offer(100);
        pq.offer(50);
        pq.offer(10);

        boolean res = canGiveMoney(pq, 5100);
    }

    private static boolean canGiveMoney(PriorityQueue<Integer> pq, int amount) {
        while (amount > 0) {
            if (pq.isEmpty() && amount > 0) {
                return false;
            }
            int diff = amount - pq.peek();
            if (diff == 0) {
                return true;
            } else if (diff > 0) {
                amount -= pq.poll();
            } else if (diff < 0) {
                pq.poll();
            }
        }
        return false;
    }
}