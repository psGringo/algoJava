package org.example;


/**
 * https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/
 */
public class Main {
    public static void main(String[] args) {
        minimumRecolors("WBBWWBBWBW", 7);
    }

    public static int minimumRecolors(String blocks, int k) {
        // find substring with length k with max black blocks
        int maxBlackBlocks = 0;
        for (int i = 0; i < blocks.length(); i++) {
            int j = i;
            while (j < blocks.length()) {
                if (j - i + 1 == k) {
                    int nextMaxBlackBlocks = Math.max(maxBlackBlocks, getCountBlackBlocks(blocks, i, j));
                    if (nextMaxBlackBlocks > maxBlackBlocks) {
                        maxBlackBlocks = nextMaxBlackBlocks;
                    }
                }
                j++;
            }
        }
        int countWhiteBlocks = k - (maxBlackBlocks);

        return countWhiteBlocks;
    }

    private static int getCountBlackBlocks(String blocks, int i, int j) {
        int count = 0;
        for (int k = i; k <= j; k++) {
            if (blocks.charAt(k) == 'B') {
                count++;
            }
        }
        return count;
    }
}