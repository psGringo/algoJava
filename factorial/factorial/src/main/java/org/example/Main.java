package org.example;


public class Main {
    public static void main(String[] args) {
        int res1 = factorialRecursive(3);
        int res2 = factorialIterative(3);
    }

    private static int factorialRecursive(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }

    private static int factorialIterative(int n) {
        if (n <= 1) {
            return 1;
        }

        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }

        return res;
    }
}