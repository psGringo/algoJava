package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-prefix-divisible-by-5/
 */
public class Main {
    public static void main(String[] args) {
        prefixesDivBy5(new int[]{1, 0, 1});
    }

    public static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();

        long currNum = 0; // pay attention here, it should be long
        for (int num : nums) {
            currNum = currNum * 2 + num;
            result.add((currNum % 5) == 0);
        }

        Integer.parseInt("101",2);

        return result;
    }
}