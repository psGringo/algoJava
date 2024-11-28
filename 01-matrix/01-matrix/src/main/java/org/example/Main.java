package org.example;


import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/01-matrix/solutions/5954571/simple-solution-for-beginners/
 */
public class Main {
    public static void main(String[] args) {
        int[][] res = updateMatrix(new int[][]{{0, 1, 1, 1, 1}, {1, 1, 1, 1, 0}});
        System.out.println("RESULT: ");
        showMatrix(res);
    }

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;
                } else {
                    ans[i][j] = Integer.MAX_VALUE; // INFINITY, 'cause we will look for min values
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            if (r + 1 < m && !vis[r + 1][c]) {
                ans[r + 1][c] = ans[r][c] + 1;
                q.offer(new int[]{r + 1, c});
                vis[r + 1][c] = true;
            }

            if (r - 1 >= 0 && !vis[r - 1][c]) {
                ans[r - 1][c] = ans[r][c] + 1;
                q.offer(new int[]{r - 1, c});
                vis[r - 1][c] = true;
            }

            if (c + 1 < n && !vis[r][c + 1]) {
                ans[r][c + 1] = ans[r][c] + 1;
                q.offer(new int[]{r, c + 1});
                vis[r][c + 1] = true;
            }

            if (c - 1 >= 0 && !vis[r][c - 1]) {
                ans[r][c - 1] = ans[r][c] + 1;
                q.offer(new int[]{r, c - 1});
                vis[r][c - 1] = true;
            }
        }

        return ans;
    }

    private static void showMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

}