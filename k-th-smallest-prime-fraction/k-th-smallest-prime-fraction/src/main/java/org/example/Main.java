package org.example;


import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-th-smallest-prime-fraction/description/
 */
public class Main {
    public static void main(String[] args) {
        kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3);
    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<NumInfo> pq = new PriorityQueue<>((x, y) -> {
            if (x.fraction() > y.fraction()) {
                return 1;
            } else if (x.fraction() < y.fraction()) {
                return -1;
            }
            return 0;
        }

        );
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                pq.offer(new NumInfo(i, j, (arr[i] * 1.0 / arr[j])));
            }
        }

        NumInfo numInfo = null;
        while (k != 0) {
            numInfo = pq.poll();
            k--;
        }

        return new int[]{arr[numInfo.i()], arr[numInfo.j()]};
    }
}

record NumInfo(int i, int j, Double fraction) {
}