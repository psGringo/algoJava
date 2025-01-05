package org.example;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<NumInfo> pq = new PriorityQueue<>((x, y) -> y.num() - x.num());
        for (int i = 0; i < nums.length; i++) {
            pq.add(new NumInfo(nums[i], i));
        }

        if (pq.size() < k) {
            return null;
        }

        PriorityQueue<NumInfo> pqIndex = new PriorityQueue<>((x, y) -> x.index() - y.index());
        int j = 0;
        while (j < k) {
            pqIndex.add(pq.poll());
            j++;
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pqIndex.poll().num();
        }

        return res;
    }
}

record NumInfo(int num, int index){}