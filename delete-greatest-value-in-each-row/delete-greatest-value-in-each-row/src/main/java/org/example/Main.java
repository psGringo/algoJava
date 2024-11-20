package org.example;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2, 4}, {3, 3, 1}};
        deleteGreatestValue(grid);
    }

    public static int deleteGreatestValue(int[][] grid) {
        int[][] sortedGrid = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int[] row = new int[grid[i].length];
            for (int j = 0; j < grid[0].length; j++) {
                row[j] = grid[i][j];
            }
            Arrays.sort(row);
            for (int j = 0; j < grid[0].length; j++) {
                sortedGrid[i][j] = row[j];
            }
        }

        int sum = 0;
        int k = sortedGrid[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y)-> y - x);
        while (k > 0) {
            for (int i = 0; i < sortedGrid.length; i++) {
                int rowMax = Integer.MIN_VALUE;
                for (int j = 0; j < k; j++) {
                    rowMax = Math.max(sortedGrid[i][j], rowMax);
                }
                pq.add(rowMax);
            }
            k--;
            sum += pq.poll();
            pq.clear();
        }

        return sum;
    }
}

//HashSet<Integer> deletedColumnsSet = new HashSet<>();
//int countDeletedRows = 0;
//int sum = 0;
//int rowMaxValue = Integer.MIN_VALUE;
//int countIterations = 0;
//PriorityQueue<Integer> deletedValues = new PriorityQueue<>((x, y) -> y - x);
//        while (true) {
//                if (deletedColumnsSet.size() > 0 && deletedColumnsSet.size() == countDeletedRows) {
//        break;
//        }
//        for (int i = 0; i < grid.length; i++) {
//        for (int j = 0; j < grid[i].length; j++) {
//        if (!deletedColumnsSet.contains(j)) {
//        if (grid[i][j] > rowMaxValue) {
//rowMaxValue = grid[i][j];
//        }
//        }
//        }
//        deletedValues.add(rowMaxValue);
//rowMaxValue = Integer.MIN_VALUE;
//
//            }
//sum += deletedValues.poll();
//            deletedColumnsSet.add(grid[0].length - 1 - countIterations);
//countIterations++;
//        }
//
//        return sum;
