package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/distribute-elements-into-two-arrays-i/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }

        int k = 0;
        for (int i = 0; i < arr1.size(); i++) {
            nums[k++] = arr1.get(i);
        }

        for (int i = 0; i < arr2.size(); i++) {
            nums[k++] = arr2.get(i);
        }

        return nums;
    }

}