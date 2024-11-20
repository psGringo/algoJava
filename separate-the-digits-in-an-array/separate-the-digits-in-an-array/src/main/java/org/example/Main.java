package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/separate-the-digits-in-an-array/
 */
public class Main {
    public static void main(String[] args) {
        separateDigits(new int[]{13, 25, 83, 77});
    }

    public static int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            convert(nums[i], list, stack);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    private static void convert(int num, List<Integer> result, Stack<Integer> stack) {
        int nextNum = num;
        while (nextNum != 0) {
            int remainder = nextNum % 10;
            nextNum = nextNum / 10;
            stack.push(remainder);
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }
}