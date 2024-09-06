package org.example;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = removeDublicates(nums);
        System.out.println(k);
    }

    /**
     * 2 pointer method:
     *  left pointer is set to 0 index and shifted only when second pointer meet next unique number
     *  right pointer is shifting until the end of the array
     *
     * @param nums
     * @return
     */
    public static int removeDublicates(int[] nums) {

        if (nums.length <= 1) {
            return nums.length;
        }

        int leftIndex = 0;
        int rightIndex = 0;

        while (true) {
            rightIndex++;
            if (nums[leftIndex] != nums[rightIndex]) {
                nums[++leftIndex] = nums[rightIndex];
            }
            if (rightIndex == nums.length- 1) {
                break;
            }
        }

        int countUniqueNumbers = leftIndex + 1;

        return countUniqueNumbers;
    }
}