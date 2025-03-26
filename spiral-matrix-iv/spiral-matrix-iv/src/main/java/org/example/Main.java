package org.example;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];

        // Fill matrix with -1
        for (int i = 0; i < m; i++) {
            Arrays.fill(matrix[i], -1);
        }

        // Directions: right, down, left, up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0; // start moving right

        int row = 0, col = 0;

        while (head != null) {
            matrix[row][col] = head.val;
            head = head.next;

            int nextRow = row + directions[direction][0];
            int nextCol = col + directions[direction][1];

            // Check bounds and if cell is unfilled
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || matrix[nextRow][nextCol] != -1) {
                // Turn right
                direction = (direction + 1) % 4;
                nextRow = row + directions[direction][0];
                nextCol = col + directions[direction][1];
            }

            row = nextRow;
            col = nextCol;
        }

        return matrix;
    }

}