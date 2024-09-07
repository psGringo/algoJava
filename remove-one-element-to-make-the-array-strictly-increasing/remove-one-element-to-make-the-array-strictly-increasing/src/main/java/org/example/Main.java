package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/description/
 *
 * solution cases
 * https://assets.leetcode.com/users/images/e802e72a-834a-40f4-aed0-2c64819543a5_1631526224.4784555.jpeg
 */
public class Main {
    public static void main(String[] args) {

        int nums[] = {1,2,10,5,7};

        canBeIncreasing(nums);

    }

    public static boolean canBeIncreasing(int[] nums) {

        List<Integer> downFalls = getDownFalls(Arrays.stream(nums).boxed().toArray(Integer[]::new));
        if (downFalls.size() > 1) {
            return false;
        } else if (downFalls.size() == 1) {

            int peak = downFalls.get(0) - 1;

            if (peak == 0 || peak == nums.length - 2) {
                return true;
            } else if (nums[peak + 1] > nums[peak - 1] || nums[peak + 2] > nums[peak]) {
                return true;
            } else return false;


        }

        return true;
    }

    private static List<Integer> getDownFalls(Integer[] nums) {
        List<Integer> downFalls = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            boolean isDownFall = nums[i] < nums[i - 1] || nums[i] == nums[i - 1];
            if (isDownFall) {
                downFalls.add(i);
            }
        }

        return downFalls;
    }


}