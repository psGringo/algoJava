package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-product-of-three-numbers/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     * another way, iterate and multiply negatives to -1, then sort and get 3 biggest nums
     *
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        int n = nums.length;

        // Step 2: Compute the maximum product of three numbers
        int product1 = nums[n-1] * nums[n-2] * nums[n-3]; // Three largest numbers
        int product2 = nums[0] * nums[1] * nums[n-1]; // Two smallest and largest number

        return Math.max(product1, product2);
    }
}