package org.example;


public class Main {
    public static void main(String[] args) {
        averageValue(new int[]{1, 3, 6, 10, 12, 15});
    }

    public static int averageValue(int[] nums) {
        int sumOfEven = 0;
        int count = 0;
        for (int num : nums) {
            // if (num % 2 == 0 && num % 3 == 0) {
            if (num % 6 == 0) {
                sumOfEven += num;
                count++;
            }
        }

        return ((int) Math.floor(sumOfEven * 1.0 / count));
    }
}