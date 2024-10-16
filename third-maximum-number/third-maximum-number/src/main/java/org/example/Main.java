package org.example;


import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/third-maximum-number/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            if (nums[i-1] != nums[i]) {
                count++;
            }
            if (count == 3) {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }


    public int thirdMaxWithSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] distinctSortedNums =
                set.stream()
                        .sorted()
                        .mapToInt(Integer::intValue)
                        .toArray();

        if (distinctSortedNums.length - 3 >= 0) {
            return distinctSortedNums[distinctSortedNums.length - 3];
        } else {
            return distinctSortedNums[distinctSortedNums.length - 1];
        }
    }



}