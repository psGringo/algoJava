package org.example;


import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        findEvenNumbers(new int[]{2, 1, 3, 0});
    }

    /**
     * loop from 100 to 999 and check if number fit the conditions
     *
     * @param digits
     * @return
     */
    public static int[] findEvenNumbers(int[] digits) {
        if (digits.length == 0) {
            return new int[0];
        }
        int[] fq = new int[11];
        for (int i = 0; i < digits.length; i++) {
            fq[digits[i]]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for ex. number 222
        int[] tempFq = new int[11];
        for (int i = 100; i <= 999; i++) {
            if (i % 2 == 0 && checkNumber(i, fq, tempFq)) {
                pq.add(i);
            }
        }
        return pq.isEmpty() ? new int[]{} : pq.stream().mapToInt(i -> i).toArray();
    }

    private static boolean checkNumber(int number, int[] fq, int[] tempFq) {
        Arrays.fill(tempFq, 0);

        while (number != 0) {
            int num = number % 10;
            number /= 10;
            tempFq[num]++;
        }

        for (int i = 0; i < tempFq.length; i++) {
            if (fq[i] < tempFq[i]) {
                return false;
            }
        }

        return true;
    }
}