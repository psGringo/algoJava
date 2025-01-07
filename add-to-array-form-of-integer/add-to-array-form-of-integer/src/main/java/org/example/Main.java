package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1);
    }

    /**
     * more clear variant
     *
     * @param num
     * @param k
     * @return
     */
    public static List<Integer> addToArrayForm(int[] num, int k) {

        StringBuilder sb = new StringBuilder();
        for (int n : num) {
            sb.append(n);
        }

        BigInteger kBi = BigInteger.valueOf(k);
        BigInteger numBi = new BigInteger(sb.toString());
        BigInteger sum = numBi.add(kBi);

        List<Integer> result = new ArrayList<>();
        for (char c : sum.toString().toCharArray()) {
            result.add(Character.digit(c, 10));
        }

        return result;
    }

    /**
     * more fast variant
     *
     * @param num
     * @param k
     * @return
     */
    public List<Integer> addToArrayForm2(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int n = num.length;

        for (int i = n - 1; i >= 0; i--) {
            int sum = num[i] + k % 10; // Add the last digit of k to num[i]
            k /= 10; // Remove the last digit of k
            if (sum >= 10) {
                k++; // Carry over
                sum -= 10;
            }
            result.add(sum);
        }

        // Add the remaining digits of k
        while (k > 0) {
            result.add(k % 10);
            k /= 10;
        }

        // Reverse the result to get the correct order
        Collections.reverse(result);
        return result;
    }
}