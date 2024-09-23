package org.example;


import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-i/description/
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};

        int[] res = nextGreaterElement(nums, nums2);

    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] greaterArr = new int[nums2.length];
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            map.put(nums2[i], i);
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(nums2[i]);
            } else {
                greaterArr[i] = stack.peek();
                stack.push(nums2[i]);
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            int index = map.get(nums1[i]);
            res[i] = greaterArr[index] == 0 ? -1 : greaterArr[index];
        }

        return res;
    }
}