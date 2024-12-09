package org.example;


public class Main {
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] res = floodFill(image, 1, 1, 2);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] visited = new int[image.length][image[0].length];
        int originalColor = image[sr][sc];
        dfs(image, sr, sc, color, sr, sc, originalColor, visited);
        return image;
    }


    public static void dfs(int[][] image, int sr, int sc, int color, int row, int col, int originColor, int[][] visited) {
        if (isOutOfBounds(image, row, col) || visited[row][col] == 1) {
            return;
        }

        visited[row][col] = 1;

        if (image[row][col] == originColor) {
            image[row][col] = color;

            // top
            dfs(image, sr, sc, color, row - 1, col, originColor, visited);
            // right
            dfs(image, sr, sc, color, row, col + 1, originColor, visited);
            // bottom
            dfs(image, sr, sc, color, row + 1, col, originColor, visited);
            // left
            dfs(image, sr, sc, color, row, col - 1, originColor, visited);
        }
    }

    private static boolean isOutOfBounds(int[][] image, int row, int col) {
        return row < 0 || row >= image.length || col < 0 || col >= image[0].length;
    }
}