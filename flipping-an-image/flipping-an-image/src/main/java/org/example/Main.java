package org.example;


/**
 * https://leetcode.com/problems/flipping-an-image/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                // inverse
                image[i][j] = image[i][j] == 1 ? 0 : 1;
            }
        }

        // flip horizontally
        int[][] newImage = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                newImage[i][newImage.length - 1 - j] = image[i][j];
            }
        }

        return newImage;
    }
}