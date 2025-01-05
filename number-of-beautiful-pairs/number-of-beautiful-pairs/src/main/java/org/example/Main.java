package org.example;

public class Main {
    public static void main(String[] args) {
        countBeautifulPairs(new int[]{11, 21, 12});
    }

    public static int countBeautifulPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int num1 = getFirstDigit(nums[i]);
                int num2 = getLastDigit(nums[j]);
                int gcd = getGCD(num1, num2);
                if (gcd == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    private static int getGCD(int num1, int num2) {
        int max = Integer.MIN_VALUE;
        int minNum = Math.min(num1, num2);
        for (int i = 1; i <= minNum; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                max = Math.max(max, i);
            }
        }
        return max;
    }

    private static int getFirstDigit(int num) {
        int digit = 0;
        while (num != 0) {
            digit = num % 10;
            num = num / 10;
        }

        return digit;
    }

    private static int getLastDigit(int num) {
        return num % 10;
    }

}