package org.example;


/**
 * https://leetcode.com/problems/find-the-array-concatenation-value/description/
 */
public class Main {
    public static void main(String[] args) {
        findTheArrayConcVal(new int[]{5, 14, 13, 8, 12});
    }

    public static long findTheArrayConcVal(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        long result = 0;
        StringBuilder sb = new StringBuilder();
        while (i <= j) {
            if (Math.abs(i - j) >= 1) {
                int num1 = nums[i];
                int num2 = nums[j];
                sb.append(num1);
                sb.append(num2);
                result += Integer.parseInt(sb.toString());
                sb.setLength(0);
            } else {
                int num1 = nums[i];
                result += num1;
            }

            i++;
            j--;
        }
        return result;
    }
}