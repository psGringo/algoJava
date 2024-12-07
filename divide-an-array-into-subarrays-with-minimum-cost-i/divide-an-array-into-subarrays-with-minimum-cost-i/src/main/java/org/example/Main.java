package org.example;


import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        minimumCost(new int[]{1, 2, 3, 12});
    }

    // https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/
    public int minimumCost(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) { // Loop through the entire array
            if (nums[i] < min) {
                secondMin = min;
                min = nums[i];
            } else if (nums[i] < secondMin) {
                secondMin = nums[i];
            }

        }

        return nums[0] + min + secondMin;
    }
}

//    public static int minimumCost(int[] nums) {
//        HashSet<Integer> exceptIndexSet = new HashSet<>();
//        int first = nums[0];
//        exceptIndexSet.add(0);
//
//        int second = getMinExcept(nums, exceptIndexSet);
//        int third = getMinExcept(nums, exceptIndexSet);
//
//        return first + second + third;
//    }
//
//    private static int getMinExcept(int[] nums, Set<Integer> exceptIndexSet) {
//        int min = Integer.MAX_VALUE;
//        int minIndex = -1;
//        for (int i = 0; i < nums.length; i++) {
//            if (!exceptIndexSet.contains(i)) {
//                int nextMin = Math.min(min, nums[i]);
//                if (nextMin < min) {
//                    minIndex = i;
//                    min = nextMin;
//                }
//
//            }
//        }
//
//        exceptIndexSet.add(minIndex);
//        return min;
//    }
//    }