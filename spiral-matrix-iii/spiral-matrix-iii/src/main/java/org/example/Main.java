package org.example;


public class Main {
    public static void main(String[] args) {
        spiralMatrixIII(5, 6, 1, 4);
    }

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int resultIndex = 0;

        // Directions: right, down, left, up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int currRow = rStart, currCol = cStart;
        int step = 1; // Step size
        int dir = 0; // Direction index

        result[resultIndex++] = new int[]{currRow, currCol};

        while (resultIndex < rows * cols) {
            for (int i = 0; i < 2; i++) { // Each step size repeats twice, spiral law
                for (int j = 0; j < step; j++) {
                    currRow += directions[dir][0];
                    currCol += directions[dir][1];

                    // Only add valid cells to result
                    if (currRow >= 0 && currRow < rows && currCol >= 0 && currCol < cols) {
                        result[resultIndex++] = new int[]{currRow, currCol};
                    }
                }
                dir = (dir + 1) % 4; // Rotate direction
            }
            step++; // Increase step size every two turns
        }

        return result;
    }

    public int[][] spiralMatrixIIINotOptimalAndNotWorking(int rows, int cols, int rStart, int cStart) {

        boolean[][] visited = new boolean[rows][cols];
        visited[rStart][cStart] = true;
        int squareSide = 2;
        int[][] result = new int[rows * cols][2];
        int resultIndex = 0;


        int currRow = rStart - 1;
        int currCol = cStart + 1;
        int i = 0;
        int j = 0;
        while (true) {
            // bottom
            while (i < squareSide) {
                currRow++;
                // if in bounds
                if (isInBounds(rows, cols, currRow, currCol)) {
                    visited[currRow][currCol] = true;
                    result[resultIndex][0] = currRow;
                    result[resultIndex][1] = currCol;
                    resultIndex++;
                }
                i++;
            }
            i = 0;

            // left
            while (j < squareSide) {
                currCol--;
                // if in bounds
                if (isInBounds(rows, cols, currRow, currCol)) {
                    visited[currRow][currCol] = true;
                    result[resultIndex][0] = currRow;
                    result[resultIndex][1] = currCol;
                    resultIndex++;
                }
                j++;
            }
            j = 0;


            // top
            while (i < squareSide) {
                currRow--;
                // if in bounds
                if (isInBounds(rows, cols, currRow, currCol)) {
                    visited[currRow][currCol] = true;
                    result[resultIndex][0] = currRow;
                    result[resultIndex][1] = currCol;
                    resultIndex++;
                }
                i++;
            }
            i = 0;

            // right
            while (j < squareSide) {
                currCol++;
                if (isInBounds(rows, cols, currRow, currCol)) {
                    visited[currRow][currCol] = true;
                    result[resultIndex][0] = currRow;
                    result[resultIndex][1] = currCol;
                    resultIndex++;
                }

                j++;
            }
            j = 0;

            if (isAllVisited(visited)) {
                break;
            }

            currRow++;
            currCol++;
            squareSide++;
        }

        return result;

    }

    private boolean isInBounds(int rows, int cols, int currRow, int currCol) {
        return (currRow >= 0 && currRow < rows && currCol >= 0 && currCol < cols);
    }

    private boolean isAllVisited(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited.length; j++) {
                if (visited[i][j] == false) {
                    return false;
                }
            }
        }
        return true;
    }
}