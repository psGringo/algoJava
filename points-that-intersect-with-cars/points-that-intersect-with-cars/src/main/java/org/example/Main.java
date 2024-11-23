package org.example;


import java.util.List;

/**
 * https://leetcode.com/problems/points-that-intersect-with-cars/description/
 */
public class Main {
    public static void main(String[] args) {
        numberOfPoints(List.of(List.of(3, 6), List.of(1, 5), List.of(4, 7)));
    }

    public static int numberOfPoints(List<List<Integer>> nums) {
        int[] fq = new int[102];
        for (int i = 0; i < nums.size(); i++) {
            for (int j = nums.get(i).get(0); j <= nums.get(i).get(1); j++) {
                fq[j]++;
            }
        }

        int count = 0;
        for (int i = 0; i < fq.length; i++) {
            if (fq[i] > 0) {
                count++;
            }
        }
        return count;
    }
}