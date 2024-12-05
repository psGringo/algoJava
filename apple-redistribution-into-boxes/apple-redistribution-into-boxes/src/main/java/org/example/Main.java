package org.example;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        minimumBoxes(new int[]{5, 5, 5}, new int[]{2, 4, 2, 7});
    }

    public static int minimumBoxes(int[] apple, int[] capacity) {
        int countApples = Arrays.stream(apple).sum();
        Arrays.sort(capacity);
        int i = capacity.length - 1;
        int countBoxes = 1;
        while (countApples > 0) {
            if (capacity[i] == 0) {
                countBoxes++;
                i--;
            }
            capacity[i]--;
            countApples--;
        }
        return countBoxes;
    }
}