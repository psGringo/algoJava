package org.example;


/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/?envType=problem-list-v2&envId=vthevgcm
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     *
     * Мы не ищем квадраты «в лоб».
     * Вместо этого, в каждой клетке мы храним:
     * сколько квадратов можно построить, заканчивая в ней.
     *
     * Потом просто суммируем все эти значения.
     *
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int total = 0;

        // dp[i][j] = размер наибольшего квадрата с правым нижним углом в (i, j)
        int[][] dp = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        // В первой строке и первом столбце
                        // можно построить только квадрат 1×1
                        dp[i][j] = 1;
                    } else {
                        // Минимум из трёх соседей (слева, сверху, диагональ)
                        dp[i][j] = 1 + Math.min(
                                Math.min(dp[i - 1][j], dp[i][j - 1]),
                                dp[i - 1][j - 1]
                        );
                    }

                    // Каждая клетка dp[i][j] добавляет
                    // столько квадратов, сколько её значение
                    total += dp[i][j];
                }
            }
        }

        return total;
    }
}