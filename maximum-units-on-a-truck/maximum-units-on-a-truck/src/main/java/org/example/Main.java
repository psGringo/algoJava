package org.example;


import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/maximum-units-on-a-truck/description/
 */
public class Main {
    public static void main(String[] args) {
        maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4);
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        List<int[]> sortedBoxes = Arrays.asList(boxTypes);
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        for (int[] box : boxTypes) {
            pq.offer(new Integer[]{box[0], box[1]});
        }

        int totalCountUnits = 0;
        int countBoxes = 0;
        while (pq.size() > 0) {
            Integer[] boxType = pq.poll();
            for (int i = 1; i <= boxType[0]; i++) {
                if (countBoxes >= truckSize) {
                    return totalCountUnits;
                }
                countBoxes++;
                totalCountUnits += boxType[1];
            }
        }

        return totalCountUnits;
    }
}