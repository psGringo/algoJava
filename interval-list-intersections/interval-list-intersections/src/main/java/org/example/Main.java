package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/interval-list-intersections/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> result = new ArrayList<>();

        while (i < firstList.length && j < secondList.length) {
            var lo = Math.max(firstList[i][0], secondList[j][0]);
            var hi = Math.min(firstList[i][1], secondList[j][1]);
            if (lo <= hi) {
                result.add(new int[]{lo, hi});
            }

            if (firstList[i][1] <= secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

}