package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;

        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0) {
                // Check the previous and next pots
                boolean emptyPrev = (i == 0 || flowerbed[i - 1] == 0);
                boolean emptyNext = (i == length - 1 || flowerbed[i + 1] == 0);

                if (emptyPrev && emptyNext) {
                    flowerbed[i] = 1; // Plant a flower
                    n--; // Reduce the number of flowers needed

                    if (n <= 0) {
                        return true; // No more flowers to plant
                    }
                }
            }
        }

        return n <= 0; // Check if all flowers were planted
    }
}