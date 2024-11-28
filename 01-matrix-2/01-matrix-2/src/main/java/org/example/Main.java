package org.example;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/01-matrix/description/
 */
public class Main {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{0, 1, 1, 1, 1}, {1, 1, 1, 1, 0}};
        updateMatrix(mat);
    }

    /**
     * DFS Approach, gives TLE, but works anyway
     *
     * @param mat
     * @return
     */
    public static int[][] updateMatrix(int[][] mat) {
        Queue<Node> roots = new LinkedList<>();
        collectRoots(mat, roots);

        int[][][] tempAnswers = new int[roots.size()][][];
        int i = 0;
        while (!roots.isEmpty()) {
            Node root = roots.poll();
            int[][] ansMatrix = new int[mat.length][mat[0].length];
            for (int j = 0; j < ansMatrix.length; j++) {
                Arrays.fill(ansMatrix[j], Integer.MAX_VALUE);
            }
            tempAnswers[i++] = ansMatrix;
            dfs(root, root, ansMatrix);
        }

        int[][] finalAnswers = new int[mat.length][mat[0].length];
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                finalAnswers[r][c] = getMinValue(tempAnswers, r, c);
            }
        }
        return finalAnswers;
    }

    private static int getMinValue(int[][][] mat, int row, int col) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][row][col] < min) {
                min = mat[i][row][col];
            }
        }
        return min;
    }

    private static void dfs(Node root, Node node, int[][] ansMatrix) {
        if (isOutOfBounds(node, ansMatrix)) {
            return;
        }
        boolean isVisited = ansMatrix[node.row()][node.col()] != Integer.MAX_VALUE;
        if (isVisited) {
            return;
        }

        int dist = Math.abs(root.row() - node.row()) + Math.abs(root.col() - node.col());
        ansMatrix[node.row()][node.col()] = dist;

        // spread in 4 directions, because we are in matrix and each cell like a node
        // right
        dfs(root, new Node(node.row(), node.col() + 1), ansMatrix);
        // left
        dfs(root, new Node(node.row(), node.col() - 1), ansMatrix);
        // top
        dfs(root, new Node(node.row() - 1, node.col()), ansMatrix);
        // bottom
        dfs(root, new Node(node.row() + 1, node.col()), ansMatrix);

    }

    private static void collectRoots(int[][] mat, Queue<Node> q) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Node(i, j));
                }
            }
        }
    }

    private static boolean isOutOfBounds(Node node, int[][] matrix) {
        boolean outRow = node.row() > matrix.length - 1 || node.row() < 0;
        boolean outCol = node.col() > matrix[0].length - 1 || node.col() < 0;
        return outRow || outCol;
    }

}

record Node(int row, int col) {
}