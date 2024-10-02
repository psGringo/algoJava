package org.example;


public class Main {
    public static void main(String[] args) {
        int res1 = factorialRecursive(10);
        int res2 = factorialIterative(10);
    }

    private static int factorialRecursive(int n) {
        return n <= 1 ? 1 : n * factorialRecursive(n - 1);
    }

    private static int factorialIterative(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                res += 1;
            } else {
                res = i * res;
            }
        }
        return res;
    }
}