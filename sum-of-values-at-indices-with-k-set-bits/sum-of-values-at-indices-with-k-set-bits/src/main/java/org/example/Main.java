package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/
 */
public class Main {
    public static void main(String[] args) {
     sumIndicesWithKSetBits(List.of(5,10,1,5,2), 1);
    }

    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
          List<Integer> indices = new ArrayList<>();
          for (int i = 0; i < nums.size(); i++) {
              addIndexIfNeeded(k, i, indices, i);
          }
          int sum = 0;
          for (int i = 0; i < indices.size(); i++) {
              sum += nums.get(indices.get(i));
          }
          return sum;
    }

    private static void addIndexIfNeeded(int k, int num, List<Integer> indices, int i) {
        int count = 0;
        String binaryString = Integer.toBinaryString(num);
        for (int j = 0; j < binaryString.length(); j++) {
            if (binaryString.charAt(j) == '1') {
                count++;

            }
        }
        if (count == k) {
            indices.add(i);
        }
    }

}