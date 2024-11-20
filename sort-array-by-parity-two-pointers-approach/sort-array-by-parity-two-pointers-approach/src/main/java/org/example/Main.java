package org.example;


/**
 * 2 pointers approach,
 * <p>
 * https://leetcode.com/problems/sort-array-by-parity/
 */
public class Main {
    public static void main(String[] args) {
        sortArrayByParity(new int[]{0, 1});
    }

    public static int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] % 2 != 0) {
                swap(nums, left, right);
                right--;
            } else {
                left++;
            }
        }
        return nums;
    }

    public static void swap(int nums[], int j, int k) {
        int temp = nums[j];
        nums[j] = nums[k];
        nums[k] = temp;
    }

    /**
     * tried by myself
     * too many custom cases...
     *
     * @param nums
     * @return
     */
    public static int[] sortArrayByParity2(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int i = 0, j = nums.length - 1;
        // first even index
        for (int k = nums.length - 1; k > 0; k--) {
            if (nums[k - 1] % 2 != 0 && nums[k] != 0) {
                j = k;
                break;
            }
        }
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] % 2 != 0) {
                i = k;
                break;
            }
        }
        while (i < j && i <= nums.length - 1 && j <= nums.length - 1) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j++;
            i++;
        }
        return nums;
    }
}