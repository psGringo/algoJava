package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/find-missing-and-repeated-values/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        HashSet<Integer> allNumsSet = new HashSet<>();
        for (int i = 1; i <= n * n; i++) {
            allNumsSet.add(i);
        }

        System.out.println(allNumsSet.size());

        int dublicate = Integer.MIN_VALUE;
        HashSet<Integer> catchDublicateSet = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                catchDublicateSet.add(grid[i][j]);
                if (catchDublicateSet.contains(grid[i][j])) {
                    dublicate = grid[i][j];
                    break;
                }

            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                allNumsSet.remove(grid[i][j]);
            }
        }

        Integer[] missing = allNumsSet.toArray(new Integer[allNumsSet.size()]);

        return new int[]{
                dublicate,
                missing[0]
        };
    }


}