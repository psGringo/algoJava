package org.example;


/**
 * https://leetcode.com/problems/remove-element/description
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     * 2 pointers approach
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != val) {
                  nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }

}