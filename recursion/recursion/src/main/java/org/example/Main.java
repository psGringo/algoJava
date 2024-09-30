package org.example;


public class Main {


    public static void main(String[] args) {
        System.out.println(recursion(10));
    }

    private static int recursion(int n) {
        if (n == 0) {
            return 1;
        }
        System.out.println("Diving ");
        int res = n + recursion(n - 1);
        System.out.println("Floating up %s".formatted(res));
        return res;
    }
}