package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/available-captures-for-rook/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int numRookCaptures(char[][] board) {
        int answer = 0;
        ChessPiece rook = getRook(board);
        System.out.println("row: %d, col: %d".formatted(rook.row(), rook.col()));
        //TOP
        int i = 1;
        while (true) {
            if (isOutOfBorders(board, rook.row() - i, rook.col())) {
                break;
            } else {
                char nextChar = board[rook.row() - i][rook.col()];
                if (nextChar == 'p') {
                    answer++;
                    break;
                } else if (nextChar == 'B') {
                    break;
                }
            }
            i++;
        }
        System.out.println(answer);
        i = 1;
        //RIGHT
        while (true) {
            if (isOutOfBorders(board, rook.row(), rook.col() + i)) {
                break;
            } else {
                char nextChar = board[rook.row()][rook.col() + i];
                if (nextChar == 'p') {
                    answer++;
                    break;
                } else if (nextChar == 'B') {
                    break;
                }
            }
            i++;
        }
        System.out.println(answer);
        //BOTTOM
        i = 1;
        while (true) {
            if (isOutOfBorders(board, rook.row() + i, rook.col())) {
                break;
            } else {
                char nextChar = board[rook.row() + i][rook.col()];
                if (nextChar == 'p') {
                    answer++;
                    break;
                } else if (nextChar == 'B') {
                    break;
                }
            }
            i++;
        }
        System.out.println(answer);
        //LEFT
        i = 1;
        while (true) {
            if (isOutOfBorders(board, rook.row(), rook.col() - i)) {
                break;
            } else {
                char nextChar = board[rook.row()][rook.col() - i];
                if (nextChar == 'p') {
                    answer++;
                    break;
                } else if (nextChar == 'B') {
                    break;
                }
            }
            i++;
        }

        return answer;
    }

    private static ChessPiece getRook(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    return new ChessPiece(i, j);
                }
            }
        }
        return null;
    }

    private boolean isOutOfBorders(char[][] board, int row, int col) {
        return row < 0 || row >= board.length || col < 0 || col >= board[0].length;
    }

}

record ChessPiece(int row, int col) {
}