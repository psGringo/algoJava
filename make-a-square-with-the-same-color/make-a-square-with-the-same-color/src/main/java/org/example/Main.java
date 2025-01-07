package org.example;


/**
 * https://leetcode.com/problems/make-a-square-with-the-same-color/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean canMakeSquare(char[][] grid) {
        // Iterate over the possible top-left corners of 2x2 subgrids
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int blackCount = 0;
                int whiteCount = 0;

                // Count 'B' and 'W' in the current 2x2 subgrid
                for (int x = 0; x < 2; x++) {
                    for (int y = 0; y < 2; y++) {
                        if (grid[i + x][j + y] == 'B') {
                            blackCount++;
                        } else {
                            whiteCount++;
                        }
                    }
                }

                // Check if we can make all cells the same color with at most one change
                if (blackCount >= 3 || whiteCount >= 3) {
                    return true;
                }
            }
        }

        return false;
    }
}