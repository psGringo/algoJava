package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/intersection-of-multiple-arrays/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public List<Integer> intersection(int[][] nums) {
        int[] fq = new int[1002];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                fq[nums[i][j]]++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < fq.length; i++) {
            if (fq[i] == nums.length) {
                result.add(i);
            }
        }
        return result;
    }

}