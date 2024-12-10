package org.example;


/**
 * https://leetcode.com/problems/check-if-matrix-is-x-matrix/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean checkXMatrix(int[][] grid) {
       for (int i = 0; i < grid.length; i++) {
           for (int j = 0; j < grid[0].length; j++) {
               int n = grid[0].length;
               boolean isDiagonal = i == j || i == n - 1 - j;
               if (isDiagonal && grid[i][j] == 0) {
                   return false;
               } else if (!isDiagonal && grid[i][j] != 0) {
                   return false;
               }
           }
       }
       return true;
    }

}