package org.example;


public class Main {
    public static void main(String[] args) {
        minimumPushes("abhrlngxyjkezwcm");
    }

    public static int minimumPushes(String word) {
        int count = 0;
        int integer = word.length() / 8;
        int remainder = word.length() % 8;

        for (int i = 1; i <= integer; i++) {
            count += 8 * i;
        }

        if (remainder != 0) {
            count += remainder * (integer + 1);
        }

        return count;
    }
}