package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public List<Integer> minSubsequence(int[] nums) {
        int[] fq = new int[101];
        int totalSum = 0;
        for (int num : nums) {
            fq[num]++;
            totalSum += num;
        }

        int halfSum = totalSum / 2;
        int subsequenceSum = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 100; i >= 0; i--) {
            // count frequencies
            for (int j = 0; j < fq[i]; j++) {
                subsequenceSum += i;
                result.add(i);
                if (subsequenceSum > halfSum) {
                    return result;
                }
            }
        }
        return result;
    }
}