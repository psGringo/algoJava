package org.example;


import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        distinctAverages(new int[]{4, 1, 4, 0, 3, 5});
    }

    public static int distinctAverages(int[] nums) {
        // sort
        // use 2 pointers techinque
        HashSet<Double> avgsSet = new HashSet<Double>();
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            double avg = ((double) nums[i] + (double) nums[j]) / 2;
            avgsSet.add(avg);
            i++;
            j--;
        }
        return (int) avgsSet.size();
    }
}