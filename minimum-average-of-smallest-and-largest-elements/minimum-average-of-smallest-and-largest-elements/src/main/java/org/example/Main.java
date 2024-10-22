package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-average-of-smallest-and-largest-elements/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public double minimumAverage(int[] nums) {
        List<Double> list = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int min = nums[i];
            int max = nums[j];
            list.add((min + max) / 2.0);
            i++;
            j--;
        }

        Double[] arr = list.toArray(new Double[list.size()]);
        Arrays.sort(arr);
        return arr[0];
    }

}