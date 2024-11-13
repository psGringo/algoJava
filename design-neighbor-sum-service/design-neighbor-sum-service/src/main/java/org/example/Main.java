package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/design-neighbor-sum-service/description/
 */
public class Main {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        var n = new NeighborSum(grid);
        n.adjacentSum(1);
    }

}

class NeighborSum {

    private final int[][] grid;
    private HashMap<Integer, Coord> map;

    private int rightBorderIndex;
    private int bottomBorderIndex;

    public NeighborSum(int[][] grid) {
        this.grid = grid;
        map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                map.put(grid[i][j], new Coord(i, j));
            }
        }

        rightBorderIndex = grid[0].length - 1;
        bottomBorderIndex = grid.length - 1;
    }

    public int adjacentSum(int value) {
        return getLeftSum(value) + getTopSum(value) + getRightSum(value) + getBottomSum(value);
    }

    private int getLeftSum(int value) {
        int res = 0;
        Coord coord = map.get(value);
        int j = coord.j() - 1;
        while (j >= 0) {
            res += grid[coord.i()][j--];
            break; // only adjacent
        }

        return res;
    }

    private int getTopSum(int value) {
        int res = 0;
        Coord coord = map.get(value);
        int i = coord.i() - 1;
        while (i >= 0) {
            res += grid[i--][coord.j()];
            break; // only adjacent
        }

        return res;
    }

    private int getBottomSum(int value) {
        int res = 0;
        Coord coord = map.get(value);
        int i = coord.i() + 1;
        while (i < grid.length) {
            res += grid[i++][coord.j()];
            break; // only adjacent
        }

        return res;
    }

    private int getRightSum(int value) {
        int res = 0;
        Coord coord = map.get(value);
        int j = coord.j() + 1;
        while (j < grid[0].length) {
            res += grid[coord.i()][j++];
            break; // only adjacent
        }

        return res;
    }

    public int diagonalSum(int value) {
        return getTopLeftSum(value) + getTopRightSum(value) + getBottomLeftSum(value) + getBottomRightSum(value);
    }

    private int getTopLeftSum(int value) {
        Coord coord = map.get(value);
        if (isInBorders(coord.i() - 1, coord.j() - 1)) {
            return grid[coord.i() - 1][coord.j() - 1];
        }

        return 0;
    }

    private int getTopRightSum(int value) {
        Coord coord = map.get(value);
        if (isInBorders(coord.i() - 1, coord.j() + 1)) {
            return grid[coord.i() - 1][coord.j() + 1];
        }

        return 0;
    }

    private int getBottomLeftSum(int value) {
        Coord coord = map.get(value);
        if (isInBorders(coord.i() + 1, coord.j() - 1)) {
            return grid[coord.i() + 1][coord.j() - 1];
        }

        return 0;
    }

    private int getBottomRightSum(int value) {
        Coord coord = map.get(value);
        if (isInBorders(coord.i() + 1, coord.j() + 1)) {
            return grid[coord.i() + 1][coord.j() + 1];
        }

        return 0;
    }

    private boolean isInBorders(int i, int j){
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
}

record Coord(int i, int j) {
}