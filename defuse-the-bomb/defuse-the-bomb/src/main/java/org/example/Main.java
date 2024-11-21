package org.example;


import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/defuse-the-bomb/description/
 */
public class Main {
    public static void main(String[] args) {
        decrypt(new int[]{2, 4, 9, 3}, -2);
    }


    public static int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];

        if (k > 0) {
            for (int i = 0; i < code.length; i++) {
                int j = i + 1;
                int count = 0;
                int sum = 0;
                while (count < k) {
                    if (j > code.length - 1) {
                        j = 0;
                    }
                    sum += code[j];
                    count++;
                    j++;
                }
                res[i] = sum;
            }
        } else if (k < 0) {
            for (int i = 0; i < code.length; i++) {
                int j = i - 1;
                int count = 0;
                int sum = 0;
                while (count < Math.abs(k)) {
                    if (j < 0) {
                        j = code.length - 1;
                    }
                    sum += code[j];
                    count++;
                    j--;
                }
                res[i] = sum;
            }
        }

        return res;
    }

    private int getNext(Queue<Integer> q) {
        int value = q.poll();
        q.add(value);
        return value;
    }
}