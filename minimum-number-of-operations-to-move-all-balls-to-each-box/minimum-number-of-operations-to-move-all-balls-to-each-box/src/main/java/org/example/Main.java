package org.example;


/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 */
public class Main {
    public static void main(String[] args) {
        int[] res = minOperations("110");
    }

    public static int[] minOperations(String boxes) {
        int n = boxes.length();
        int answer[] = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (boxes.charAt(j) == '1') {
                    count += Math.abs(j - i);
                }
            }
            answer[i] = count;
            count = 0;
        }
        return answer;
    }
}

