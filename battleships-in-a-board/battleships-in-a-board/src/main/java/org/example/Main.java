package org.example;


/**
 * https://leetcode.com/problems/battleships-in-a-board/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int countBattleships(char[][] board) {
        int countShips = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 'S' && board[i][j] == 'X') {
                    dfs(board, i, j);
                    countShips++;
                }
            }
        }
        return countShips;
    }

    private void dfs(char[][] board, int row, int col) {
        if (board[row][col] == 'X') {
            board[row][col] = 'S';
        }
        // TOP
        if (row > 0 && board[row - 1][col] == 'X') {
            dfs(board, row - 1, col);
        }
        // BOTTOM
        if (row < board.length - 1 && board[row + 1][col] == 'X') {
            dfs(board, row + 1, col);
        }
        // LEFT
        if (col > 0 && board[row][col - 1] == 'X') {
            dfs(board, row, col - 1);
        }
        // RIGHT
        if (col < board[0].length - 1 && board[row][col + 1] == 'X') {
            dfs(board, row, col + 1);
        }
    }

}