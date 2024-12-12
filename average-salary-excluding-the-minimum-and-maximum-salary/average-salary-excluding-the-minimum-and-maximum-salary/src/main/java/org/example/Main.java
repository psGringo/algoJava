package org.example;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        average(new int[]{4000, 3000, 1000, 2000});
    }

    public static double average(int[] salary) {
        Arrays.sort(salary);
        int sum = 0;
        int count = 0;
        for (int i = 1; i < salary.length - 1; i++) {
            sum += salary[i];
            count++;
        }
        return sum * 1.0 / count;
    }

}