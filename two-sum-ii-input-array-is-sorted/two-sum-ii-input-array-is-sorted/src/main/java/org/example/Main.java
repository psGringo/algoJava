package org.example;


/**
 *  https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class Main {
    public static void main(String[] args) {
     int[] nums = {2,7,11,15};
     int[] res = twoSum(nums, 9);
    }

    /**
     * we use here two pointers method
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
      int left = 0;
      int right = numbers.length - 1;
      while (left <= right) {
          int sum = numbers[left] + numbers[right];
          if (sum > target) {
              right--;
          } else if (sum < target) {
              left++;
          } else {
              return new int[]{++left, ++right};
          }
      }
      return null;
    }

}