package org.example;


/**
 * https://leetcode.com/problems/rotating-the-box/description/
 */
public class Main {
    public static void main(String[] args) {
        char[][] box = new char[][]{
                new char[]{'#', '.', '*', '.'}
                ,new char[]{'#', '#', '*', '.'}
        };
//        printBox(box);
        System.out.println("rotated box");
        printBox(rotateTheBox(box));
    }

    public static char[][] rotateTheBox(char[][] box) {

        fallStones(box);

        var rotatedBox = new char[box[0].length][box.length];

        for (int i = 0; i < rotatedBox.length; i++) {
            for (int j = 0; j < rotatedBox[0].length; j++) {
                rotatedBox[i][j] = box[box.length - 1 - j][i];
            }
        }
        return rotatedBox;
    }

    private static void fallStones(char[][] rotatedBox) {
        for (int i = 0; i < rotatedBox.length; i++) {
            fallStone(rotatedBox[i]);
        }
    }

    private static void fallStone(char[] column) {
        int fallIndex = column.length - 1;
        for (int i = column.length - 1; i >= 0; i--) {
            if (column[i] == '*') {
                fallIndex = i - 1;
            } else if (column[i] == '#') {
                column[i] = '.';
                column[fallIndex] = '#';
                fallIndex--;
            }
        }
    }

    private static void printBox(char[][] box) {
        for (char[] row : box) {
            for (char column : row) {
                System.out.print(column);
            }
            System.out.println();
        }
    }

}