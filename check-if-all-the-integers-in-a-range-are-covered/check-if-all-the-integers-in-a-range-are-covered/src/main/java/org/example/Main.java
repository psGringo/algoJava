package org.example;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public boolean isCovered(int[][] ranges, int left, int right) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];
            for (int j = range[0]; j <= range[1]; j++) {
                set.add(j);
            }
        }
        for (int i = left; i <= right; i++) {
            if (!set.contains(i)) {
                return false;
            }
        }

        return true;
    }
}