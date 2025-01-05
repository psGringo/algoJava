package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public int maxCount(int m, int n, int[][] ops) {
        int minA = m;
        int minB = n;

        for (int[] op : ops) {
            minA = Math.min(minA, op[0]);
            minB = Math.min(minB, op[1]);
        }

        return minA * minB;
    }
}