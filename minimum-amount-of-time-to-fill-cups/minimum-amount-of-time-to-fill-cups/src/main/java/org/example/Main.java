package org.example;


import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        fillCups(new int[]{1, 4, 2});
    }

    public static int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < amount.length; i++) {
            pq.add(amount[i]);
        }

        int countSeconds = 0;
        int first = 0;
        int second = 0;
        while (!pq.isEmpty() && pq.size() > 1) {
            first = pq.poll();
            second = pq.poll();
            if (first > 0 && second > 0) {
                first--;
                second--;
                countSeconds++;
            }
            if (first > 0) {
                pq.add(first);
            }
            if (second > 0) {
                pq.add(second);
            }


        }

        if (!pq.isEmpty() && pq.size() == 1) {
            first = pq.poll();
            if (first > 0) {
                countSeconds += first;
            }
        }

        return countSeconds;
    }
}


//            if (first == 0 && pq.size() > 0) {
//                first = pq.poll();
//            }
//            if (second == 0 && pq.size() > 0) {
//                second = pq.poll();
//            }
//
//            if (first == 0 && second > 0) {
//                while (second > 0) {
//                    second--;
//                    countSeconds++;
//                }
//            }

//            if (second == 0 && first > 0) {
//                while (first > 0) {
//                    first--;
//                    countSeconds++;
//                }
//            }
//
//            while (first > 0 && second > 0) {
//                first--;
//                second--;
//                countSeconds++;
//            }
//        }