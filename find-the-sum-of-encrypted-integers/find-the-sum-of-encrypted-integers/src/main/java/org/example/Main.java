package org.example;


public class Main {
    public static void main(String[] args) {
        sumOfEncryptedInt(new int[]{1, 2, 3});
    }

    public static int sumOfEncryptedInt(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result += getEncryptedNum(num);
        }
        return result;
    }

    private static int getEncryptedNum(int num) {
        int max = Integer.MIN_VALUE;
        int countNums = 0;
        while (num != 0) {
            int x = num % 10;
            max = Math.max(max, x);
            num = num / 10;
            countNums++;
        }
        // 111 = 100 + 10 + 1
        int res = 0;
        for (int i = countNums - 1; i >= 0; i--) {
            res += Math.pow(10, i) * max;
        }
        return res;
    }
}