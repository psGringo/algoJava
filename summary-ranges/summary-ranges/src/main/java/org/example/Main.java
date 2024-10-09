package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9});
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ranges;
        }
        int i = 0;
        int j = 0;

        while (j < nums.length - 1) {
            if (nums[j + 1] != nums[j] + 1) {
                if (i == j) {
                    ranges.add(String.valueOf(nums[i]));
                } else {
                    ranges.add(nums[i] + "->" + nums[j]);
                }
                i = j + 1;
                j = j + 1;
            } else {
                j++;
            }
        }

        if (i == j) {
            ranges.add(String.valueOf(nums[i]));
        } else {
            ranges.add(nums[i] + "->" + nums[j]);
        }

        return ranges;
    }

}