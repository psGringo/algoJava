package org.example;


import java.util.List;

/**
 * https://leetcode.com/problems/construct-the-minimum-bitwise-array-i/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int[] minBitwiseArray(List<Integer> nums) {
        final int n = nums.size();
        final int[] out = new int[n];
        int i = 0;
        for (int prime : nums) {
            out[i++] = computeMinimumOrForPrime(prime);
        }
        return out;
    }

    /**
     * https://leetcode.com/problems/construct-the-minimum-bitwise-array-i/solutions/5904765/1ms-100-java-bitwise-well-explained-test-bits-for-removal/
     *
     * Yes, we can brute force this, but why not do better?
     *
     * The ideal thing to do (if it works) would be removing the leftmost 1 in binary representation of a number and hoping that adding 1 introduces that bit back with a carry-bit in the addition. For example, 0b00111111, flip the leftmost 1 to 0b00011111 and when we add 1, we get 0b00100000 and when we take 0b00011111 | 0b00100000 we get 0b00111111, which is great! We can't remove more than 2 bits, because we'll only be able to restore one of them via carrying when adding 1. But this seems to be workable for some values.
     *
     * But always taking the leftmost bit won't work universally for all values. Take 0b00100001. If we remove the leftmost bit, and add 1, we get 0b00000001 and 0b00000010 which bitwise-OR to 0b00000011. This doesn't work.
     *
     * So, what do we do? Well, we can just try the various 1-bits and see if they work, stopping when we've passed the leftmost 1-bit and returning -1 if we didn't find anything that works. Otherwise we retain the smallest value that works.
     *
     * Also, we are told the inputs are prime. We don't need this fact other than to know that we'll never get the input 1, and the only even input we'll get is 2. And we can tell right away that 2 has no answer. The only real possibility to check is 1 and 1 | (1 + 1) is 3, so we can short-circuit if we get 2.
     *
     *
     * @param prime
     * @return
     */
    private int computeMinimumOrForPrime(int prime) {
        // If prime is 2, our answer cannot exceed 2,
        // but 1 doesn't work as 1 | 2 -> 3.
        if (prime == 2) {
            return -1;
        }
        int s = 0;
        int mask = 1;
        int best = -1;
        do {
            if ((prime & mask) == mask) {
                final int candidate = prime ^ mask;
                if ((candidate | (candidate + 1)) == prime) {
                    if (best < 0 || candidate < best) {
                        best = candidate;
                    }
                }
            }
            mask = (1 << (++s));
        } while (mask <= prime);
        return best;
    }
}