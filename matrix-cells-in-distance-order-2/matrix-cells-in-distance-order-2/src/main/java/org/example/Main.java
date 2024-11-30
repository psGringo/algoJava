package org.example;


import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        allCellsDistOrder(1, 2, 0, 0);
    }

    public static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>((x, y) -> {
            return x.dist() - y.dist();
        });

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int dist = Math.abs(r - rCenter) + Math.abs(c - cCenter);
                pq.add(new Cell(r, c, dist));             }
        }
        int[][] result = new int[pq.size()][2];
        int i = 0;
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            result[i++] = new int[]{cell.row(), cell.col()};
        }
        return result;
    }
}

record Cell(int row, int col, int dist) {
}