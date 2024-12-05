package org.example;


import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0, 1}, {1, 0, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        numSpecial(matrix);
    }

    public static int numSpecial(int[][] mat) {
        int[] rowSum = new int[mat.length];
        int[] colSum = new int[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                rowSum[i] += mat[i][j];
            }
        }

        for (int i = 0; i < mat[0].length; i++) {
            for (int j = 0; j < mat.length; j++) {
                colSum[i] += mat[j][i];
            }
        }

        int count = 0;
        HashSet<Integer> setRows = new HashSet<>();
        HashSet<Integer> setCols = new HashSet<>();
        for (int i = 0; i < mat.length; i++) {
            if (!setRows.contains(i)) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (!setCols.contains(j)) {
                        if (mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}