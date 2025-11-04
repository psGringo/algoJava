package org.example;


/**
 * https://leetcode.com/problems/maximum-xor-after-operations/?envType=problem-list-v2&envId=vthevgcm
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     * LeetCode 2317 — Maximum XOR After Operations
     *
     * Problem:
     *  You are given an integer array `nums`. You can perform any number of operations:
     *     nums[i] = nums[i] & (nums[i] ^ x)
     *  where `x` is any non-negative integer.
     *  Return the maximum possible value of the bitwise XOR of all elements after any number of operations.
     *
     * Key insight:
     *  - The allowed operation can only **turn bits off** (change 1→0), but never turn a 0→1.
     *  - For each bit position:
     *       if at least one element initially has a 1 in that bit,
     *       we can keep it as 1 in exactly one element and clear it in others
     *       → this bit will contribute 1 to the final XOR.
     *       if no element has that bit set, it will stay 0 in all numbers.
     *  - Therefore, the maximum achievable XOR has 1s in every bit that appears
     *    in any of the numbers — that is, the bitwise OR of all elements.
     *
     * Algorithm:
     *  1. Initialize `ans = 0`.
     *  2. For each value v in nums:
     *        ans |= v   // accumulate all bits that appear in any number
     *  3. Return ans.
     *
     * Complexity:
     *  - Time:  O(n)
     *  - Space: O(1)
     *
     * Example:
     *   nums = [3,2,4,6]
     *   Binary view:
     *      3 = 011
     *      2 = 010
     *      4 =100
     *      6 =110
     *   Bitwise OR = 111 = 7 → maximum XOR = 7
     *
     * @param nums array of integers
     * @return maximum possible XOR value after any number of allowed operations
     */
    public int maximumXOR(int[] nums) {
        int ans = 0;
        for (int v : nums) ans |= v;
        return ans;
    }
}