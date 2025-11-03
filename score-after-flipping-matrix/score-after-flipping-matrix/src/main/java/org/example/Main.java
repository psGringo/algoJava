package org.example;

import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        int result = matrixScore(grid);
    }


    public static int matrixScore(int[][] grid) {
        HashMap<String, String> m = new HashMap<>();
        // hrz, if first number is 0 then flip, 1000 > 0001 in bin
        // vrt, if most of column nums 0, then flip
        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            if (grid[rowIndex][0] == 0) {
                flipRow(grid, rowIndex);
            }
        }

        for (int colIndex = 0; colIndex < grid[0].length; colIndex++) {
            if (needFlipVertically(grid, colIndex)) {
                flipCol(grid, colIndex);
            }
        }

        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            result += getDecimal(grid[i]);
        }

        return result;
    }

    private static void flipRow(int[][] matrix, int row) {
        for (int colIndex = 0; colIndex < matrix[row].length; colIndex++) {
            matrix[row][colIndex] = matrix[row][colIndex] == 1 ? 0 : 1;
        }
    }

    private static void flipCol(int[][] matrix, int col) {
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            matrix[rowIndex][col] = matrix[rowIndex][col] == 1 ? 0 : 1;
        }
    }

    private static boolean needFlipVertically(int[][] grid, int col) {
        int countOnes = 0;
        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            if (grid[rowIndex][col] == 1) {
                countOnes++;
            }
        }
        return countOnes < grid.length - countOnes;
    }

    private static int getDecimal(int[] binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length; i++) {
            decimal = decimal * 2 + binary[i];
        }

        return decimal;
    }

}