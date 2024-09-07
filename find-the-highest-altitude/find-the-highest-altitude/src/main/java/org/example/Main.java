package org.example;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-the-highest-altitude/description/
 */
public class Main {
    public static void main(String[] args) {
        int[] gain = {-5,1,5,0,-7};
        int max = largestAltitude(gain);
        System.out.println("Maximum altitude is " + max);
    }

    public static int largestAltitude(int[] gain) {

        if (gain.length == 0) {
            return 0;
        }

        int[] altitudes = new int[gain.length + 1];
        altitudes[0] = 0;

        for (int i = 0; i < altitudes.length - 1; i++) {
            int nextAltitude = altitudes[i] + gain[i];
            altitudes[i + 1] = nextAltitude;
        }

        int max = Arrays.stream(altitudes).max().getAsInt();

        return max;
    }

}