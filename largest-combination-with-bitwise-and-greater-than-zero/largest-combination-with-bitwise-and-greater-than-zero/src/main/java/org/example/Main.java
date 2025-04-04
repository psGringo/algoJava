package org.example;


/**
 * https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int largestCombination(int[] candidates) {
          if (candidates.length == 1) {
              return 1;
          }

          int maxCountBits = 24;
          int max = 0;
          for (int i = 0; i < maxCountBits; i++) {
              int count = 0;
              for (int c : candidates) {
                  if ((c & (1 << i)) != 0) {
                      count++;
                  }
              }
              max = Math.max(max, count);
              if (max == candidates.length) {
                  return max;
              }
          }

          return max;
    }
}