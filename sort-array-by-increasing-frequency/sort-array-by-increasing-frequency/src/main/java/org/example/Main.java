package org.example;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/sort-array-by-increasing-frequency/
 */
public class Main {
    public static void main(String[] args) {
        int[] res = frequencySort(new int[]{1, 1, 2, 2, 2, 3});
    }

    public static int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Integer[] numsObjects = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsObjects, (x, y) -> {
          if (!map.get(x).equals(map.get(y))) {
              return map.get(x) - map.get(y);
          } else {
              return y - x;
          }
        });
        return Arrays.stream(numsObjects).mapToInt(i -> i).toArray();
    }

}

record Num(int value, int frequency) {
}