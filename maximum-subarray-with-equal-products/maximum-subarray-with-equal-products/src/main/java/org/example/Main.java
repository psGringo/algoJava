package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            long prod = 1;
            int gcd = nums[i];
            long lcm = nums[i];

            for (int j = i; j < n; j++) {
                prod *= nums[j];
                gcd = getGcd(gcd, nums[j]);
                lcm = (lcm * nums[j]) / getGcd((int) lcm, nums[j]);

                if (prod == lcm * gcd) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    private int getGcd(int a, int b) {
        return b == 0 ? a : getGcd(b, a % b);
    }
}