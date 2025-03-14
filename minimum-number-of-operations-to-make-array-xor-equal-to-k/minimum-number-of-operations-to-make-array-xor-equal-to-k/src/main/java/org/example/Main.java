package org.example;


public class Main {
    public static void main(String[] args) {

    }

    /**
     *
     * First of all calc xor representation of array
     *
     * The key insight is:
     *
     * XOR finds the difference between two numbers at the bit level.
     * The number of 1s in diff tells us how many bits must change to turn xor into k.
     * Since we can replace any element with any number, we can always flip one bit at a time by choosing appropriate values.
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public int minOperations(int[] nums, int k) {
        int xorOfArray = 0;
        for (int num : nums) {
            xorOfArray ^= num;
        }
        int diff = xorOfArray ^ k;

        return Integer.bitCount(diff);
    }
}