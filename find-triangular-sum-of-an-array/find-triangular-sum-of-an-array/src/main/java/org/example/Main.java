package org.example;


/**
 * https://leetcode.com/problems/find-triangular-sum-of-an-array/description/?envType=problem-list-v2&envId=vthevgcm
 */
public class Main {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int res = triangularSum(a);
        System.out.println(res);
    }

    /**
     * Возвращает треугольную сумму массива.
     * Итеративно сводит массив, каждый раз заменяя nums[i] = (nums[i] + nums[i+1]) % 10
     * и уменьшая «рабочую» длину на 1.
     *
     * Время: O(n^2). Память: O(1).
     * ВНИМАНИЕ: мутирует входной массив. Если это нежелательно — сделайте копию.
     */
    public static int triangularSum(int[] nums) {
        for (int len = nums.length; len > 1; len--) {
            // после этого цикла корректны элементы [0..len-2]
            for (int i = 0; i < len - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }
        return nums[0];
    }


    /**
     * @param nums
     * @return
     */
    public static int triangularSum2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] newArr = new int[nums.length -1];
        for (int i = 0; i < nums.length -1; i++) {
            newArr[i] = (nums[i] + nums[i+1]) % 10;
        }

        return triangularSum(newArr);
    }
}