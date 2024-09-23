package org.example;


import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-ii/description/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(2 % 10);
    }


    /**
     * doubling source array
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length; i >= 0; i--) {
            int index = i % nums.length;
            while (!stack.empty() && stack.peek() <= nums[index]) {
                stack.pop();
            }

            if (!stack.empty()) {
                result[index] = stack.peek();
            }
            stack.push(nums[index]);
        }

        return result;
    }


    public int[] nextGreaterElementsCircular(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; ++i) {

            while (!stack.empty() && nums[stack.peek()] < nums[i % n]) {
                result[stack.pop()] = nums[i % n];
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }


}