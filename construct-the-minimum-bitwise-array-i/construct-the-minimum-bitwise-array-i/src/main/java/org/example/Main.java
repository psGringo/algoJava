package org.example;


import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static int check(int a) {
        // Try all values of i from 0 to a-1
        for (int i = 0; i < a; i++) {
            // Check if (i | (i + 1)) is equal to a
            if ((i | (i + 1)) == a) {
                return i;
            }
        }
        // If no such i exists, return -1
        return -1;
    }

    public int[] minBitwiseArray(List<Integer> nums) {
        int[] arr = new int[nums.size()];
        // For each number in the input list, calculate the corresponding min value
        for (int i = 0; i < nums.size(); i++) {
            arr[i] = check(nums.get(i));
        }
        return arr;
    }
}