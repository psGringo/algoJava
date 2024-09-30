package org.example;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/rotting-oranges/
 */
public class Main {

    private static final int EMPTY = 0;
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;


    public static void main(String[] args) {
//        int[][] grid = new int[3][3];
//        grid[0] = new int[]{2, 1, 1};
//        grid[1] = new int[]{1, 1, 0};
//        grid[2] = new int[]{0, 1, 1};


        int[][] grid = new int[1][1];
        grid[0] = new int[]{1};

        orangesRotting(grid);
    }

    /**
     * bfs approach
     *
     * @param grid
     * @return
     */
    public static int orangesRotting(int[][] grid) {
        Queue<Orange> rottenOranges = new LinkedList<>();
        int countFresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == ROTTEN) {
                    rottenOranges.add(new Orange(i, j));
                } else if (grid[i][j] == FRESH) {
                    countFresh++;
                }
            }
        }

        if (rottenOranges.size() + countFresh == 0) {
            return 0;
        }

        if (rottenOranges.isEmpty()) {
            return -1;
        }

        int time = 0;
        List<Orange> newRottenOranges = new LinkedList<>();
        while (true) {
            while (!rottenOranges.isEmpty()) {
                spreadRottening(grid, rottenOranges.poll(), newRottenOranges);
            }
            if (newRottenOranges.size() == 0) {
                break;
            }
            countFresh -= newRottenOranges.size();
            for (Orange newRottenOrange : newRottenOranges) {
                rottenOranges.add(newRottenOrange);
            }
            newRottenOranges.clear();
            time++;
        }


        return countFresh == 0 ? time : -1;
    }

    private static void spreadRottening(int[][] grid, Orange rottenOrange, List<Orange> newRottenOranges) {

        // UP
        if (rottenOrange.i > 0 && grid[rottenOrange.i - 1][rottenOrange.j] == FRESH) {
            grid[rottenOrange.i - 1][rottenOrange.j] = ROTTEN;
            newRottenOranges.add(new Orange(rottenOrange.i - 1, rottenOrange.j));
        }
        // DOWN
        if (rottenOrange.i < grid.length - 1 && grid[rottenOrange.i + 1][rottenOrange.j] == FRESH) {
            grid[rottenOrange.i + 1][rottenOrange.j] = ROTTEN;
            newRottenOranges.add(new Orange(rottenOrange.i + 1, rottenOrange.j));
        }
        // LEFT
        if (rottenOrange.j > 0 && grid[rottenOrange.i][rottenOrange.j - 1] == FRESH) {
            grid[rottenOrange.i][rottenOrange.j - 1] = ROTTEN;
            newRottenOranges.add(new Orange(rottenOrange.i, rottenOrange.j - 1));
        }
        // RIGHT
        if (rottenOrange.j < grid[0].length - 1 && grid[rottenOrange.i][rottenOrange.j + 1] == FRESH) {
            grid[rottenOrange.i][rottenOrange.j + 1] = ROTTEN;
            newRottenOranges.add(new Orange(rottenOrange.i, rottenOrange.j + 1));
        }

    }

    static class Orange {
        private int i;
        private int j;

        public Orange(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        public void setI(int i) {
            this.i = i;
        }

        public void setJ(int j) {
            this.j = j;
        }
    }
}