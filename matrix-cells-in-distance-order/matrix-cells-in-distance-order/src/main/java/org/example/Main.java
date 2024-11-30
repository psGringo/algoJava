package org.example;


import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/matrix-cells-in-distance-order/description/
 */
public class Main {
    public static void main(String[] args) {
        allCellsDistOrder(2, 2, 0, 1);
    }

    private static int rowCount;
    private static int colCount;
    private static boolean[][] visited;

    public static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        rowCount = rows;
        colCount = cols;
        visited = new boolean[rowCount][colCount];
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) ->
                x.getDistance() - y.getDistance()
        );

        Node root = new Node(rCenter, cCenter);

        dfs(root, root, pq);

        int[][] result = new int[pq.size()][2];
        int i = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            result[i++] = new int[]{node.getRow(), node.getCol()};
        }
        return result;
    }

    private static void dfs(Node root, Node node, PriorityQueue<Node> pq) {
        if (isOutOfBounds(node) || isVisited(node)) {
            return;
        }

        int distanceFromRoot = Math.abs(root.getRow() - node.getRow()) + Math.abs(root.getCol() - node.getCol());
        node.setDistance(distanceFromRoot);
        pq.add(node);
        visited[node.getRow()][node.getCol()] = true;

        // up
        dfs(root, new Node(node.getRow() - 1, node.getCol()), pq);
        // bottom
        dfs(root, new Node(node.getRow() + 1, node.getCol()), pq);
        // left
        dfs(root, new Node(node.getRow(), node.getCol() - 1), pq);
        // right
        dfs(root, new Node(node.getRow(), node.getCol() + 1), pq);
    }

    private static boolean isVisited(Node node) {
         return visited[node.getRow()][node.getCol()];
    }

    private static boolean isOutOfBounds(Node node) {
        boolean isRowsOutOfBounds = node.getRow() < 0 || node.getRow() > rowCount - 1;
        boolean isColsOutOfBounds = node.getCol() < 0 || node.getCol() > colCount - 1;
        return isRowsOutOfBounds || isColsOutOfBounds;
    }
}

class Node {
    private int row;
    private int col;
    private int distance;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}