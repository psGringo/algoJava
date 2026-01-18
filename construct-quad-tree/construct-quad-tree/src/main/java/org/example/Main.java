package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public Node construct(int[][] grid) {
        return build(grid, grid.length, 0, 0);
    }

    private Node build(int[][] grid, int size, int startRowIndex, int startColIndex) {
        int res = traverse(grid, size, startRowIndex, startColIndex);
        if (res == 1) {
            return new Node(true, true);
        } else if (res == 0) {
            return new Node(false, true);
        }

        Node node = new Node(false, false);

        int halfSize = size / 2;
        node.topLeft = build(grid, halfSize, startRowIndex, startColIndex);
        node.topRight = build(grid, halfSize, startRowIndex, startColIndex + halfSize);
        node.bottomLeft = build(grid, halfSize, startRowIndex + halfSize, startColIndex);
        node.bottomRight = build(grid, halfSize, startRowIndex + halfSize, startColIndex + halfSize);

        return node;
    }


    private int traverse(int[][] subgrid, int size, int startRowIndex, int startColIndex) {
        boolean isAllOnes = true;
        boolean isAllZeros = true;

        int rEnd = startRowIndex + size;
        int cEnd = startColIndex + size;

        for (int row = startRowIndex; row < rEnd; row++) {
            for (int col = startColIndex; col < cEnd; col++) {
                if (subgrid[row][col] == 0) {
                    isAllOnes = false;
                }
                if (subgrid[row][col] == 1) {
                    isAllZeros = false;
                }

                if (!isAllOnes && !isAllZeros) return -1; // early exit;
            }
        }

        if (isAllOnes) {
            return 1;
        } else if (isAllZeros) {
            return 0;
        } else {
            return -1;
        }
    }
}