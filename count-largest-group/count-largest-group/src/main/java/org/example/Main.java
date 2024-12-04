package org.example;


import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/count-largest-group/description/
 */
public class Main {
    public static void main(String[] args) {
        countLargestGroup(125);
    }
    public static int countLargestGroup(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSum = 0;
        for (int i = 1; i <= n; i++) {
            int sum = getSum(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            maxSum = Math.max(maxSum, map.get(sum));
        }
        int count = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == maxSum) {
                count++;
            }
        }
        return count;
    }

//    public static int countLargestGroup2(int n) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 1; i <= n; i++) {
//            NumInfo numInfo = getNumInfo(i);
//            map.put(numInfo.sum(), map.getOrDefault(numInfo.sum(), 0) + numInfo.size());
//        }
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
//        var iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            var entry = iterator.next();
//            pq.add(entry.getValue());
//        }
//        int maxSize = pq.peek();
//        int count = 0;
//        while (!pq.isEmpty() && pq.peek() == maxSize) {
//            count++;
//            pq.poll();
//        }
//
//
//        return count;
//    }

    private static int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int remainder = n % 10;
            sum += remainder;
            n = n / 10;
        }

        return sum;
    }


    private static NumInfo getNumInfo(int n) {
        int sum = 0;
        int size = 0;
        while (n > 0) {
            size++;
            int remainder = n % 10;
            sum += remainder;
            n = n / 10;
        }
        return new NumInfo(sum, size);
    }
}

record NumInfo(int sum, int size) {
}