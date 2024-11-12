package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/decompress-run-length-encoded-list/
 */
public class Main {
    public static void main(String[] args) {
        var res = decompressRLElist(new int[]{1, 2, 3, 4});
    }

    public static int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i = i + 2) {
            int frequency = nums[i];
            int value = nums[i + 1];
            for (int j = 0; j < frequency; j++) {
                list.add(value);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}