package org.example;


import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}};
        nearestValidPoint(3, 4, points);
    }

    public static int nearestValidPoint(int x, int y, int[][] points) {
        PriorityQueue<Distance> pq = new PriorityQueue<>((x1, y1) -> {
            if (x1.value() == y1.value()) {
                return x1.index() - y1.index();
            } else {
                return x1.value() - y1.value();
            }
        });
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] == x || point[1] == y) {
                int manhattanDistance = Math.abs(point[0] - x) + Math.abs(point[1] - y);
                pq.add(new Distance(manhattanDistance, i));
            }
        }
        return pq.isEmpty() ? -1 : pq.poll().index();
    }
}

record Distance(int value, int index) {
}