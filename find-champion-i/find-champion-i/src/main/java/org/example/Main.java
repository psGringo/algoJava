package org.example;


/**
 * https://leetcode.com/problems/find-champion-i/description/
 */
public class Main {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1}, {1, 0, 1}, {0, 0, 0}};
        findChampion(grid);
    }

    public static int findChampion(int[][] grid) {

        int[] arr = new int[grid.length];

        for (var i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    arr[j]++;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            if (arr[i] == 0) {
                return i;
            }
        }
        return -1;

    }

    public static int findChampion2(int[][] grid) {

        int maxPoints = Integer.MIN_VALUE;
        int team = -1;

        for (int i = 0; i < grid.length; i++) {
            int count = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
                if (count > maxPoints) {
                    maxPoints = count;
                    team = i;
                }
            }
        }
        return team;
    }

}