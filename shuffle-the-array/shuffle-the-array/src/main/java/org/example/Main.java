package org.example;


/**
 * https://leetcode.com/problems/shuffle-the-array/description/
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int[] shufled = shuffle(nums, 3);
        for (int i = 0; i < shufled.length; i++) {
            System.out.print("%s, ".formatted(shufled[i]));
        }
    }

    public static int[] shuffle(int[] nums, int n) {

        int[] res = new int[2 * n];

        int i = 0;
        int j = n;
        int k = 0;

        while (k < 2 * n) {
            res[k] = nums[i];
            res[++k] = nums[j];
            i++;
            j++;
            k++;
        }

        return res;
    }
}