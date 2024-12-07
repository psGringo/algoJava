package org.example;


/**
 * https://leetcode.com/problems/two-furthest-houses-with-different-colors/description/
 */
public class Main {
    public static void main(String[] args) {
        maxDistance(new int[]{1, 8, 3, 8, 3});
    }

    public static int maxDistance(int[] colors) {
        int i = 0;
        int j = colors.length - 1;
        int leftDifferentColorIndex = -1;
        int rightDifferentColorIndex = -1;
        while (true) {
            i++;
            if (i < colors.length) {
                if (colors[i] != colors[0]) {
                    leftDifferentColorIndex = i;
                }
            }


            j--;
            if (j >= 0) {
                if (colors[j] != colors[colors.length - 1]) {
                    rightDifferentColorIndex = j;
                }
            }
            if (i >= colors.length - 1 && j <= 0) {
                break;
            }
        }

        int distanceLeft = Math.abs(leftDifferentColorIndex - 0);
        int distanceRight = Math.abs(colors.length - 1 - rightDifferentColorIndex);
        return Math.max(distanceLeft, distanceRight);
    }
}