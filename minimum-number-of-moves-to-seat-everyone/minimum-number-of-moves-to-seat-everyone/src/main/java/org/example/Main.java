package org.example;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            int diff = Math.abs(seats[i] - students[i]);
            count += diff;
        }
        return count;
    }

}