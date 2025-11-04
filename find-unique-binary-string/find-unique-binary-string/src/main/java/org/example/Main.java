package org.example;


/**
 * https://leetcode.com/problems/find-unique-binary-string/description/?envType=problem-list-v2&envId=vthevgcm
 */
public class Main {
    public static void main(String[] args) {

    }


    /**
     * LeetCode 1980 — Find Unique Binary String
     *
     * Problem:
     *  Given an array of n distinct binary strings, each of length n,
     *  find any binary string of length n that does not appear in the array.
     *
     * Key Idea (Cantor's Diagonalization):
     *  - Construct a new string that differs from each nums[i] in its i-th position.
     *  - Specifically, take the i-th character of nums[i], invert it ('0' → '1', '1' → '0').
     *  - Because this new string differs from every nums[i] at least in position i,
     *    it is guaranteed not to match any of them — ensuring uniqueness.
     *
     *  Example:
     *   nums = ["01", "10"]
     *   Diagonal = [nums[0][0]='0', nums[1][1]='0']
     *   Inverted diagonal → "11" → not in nums → valid result.
     *
     * Algorithm:
     *  1. Initialize an empty StringBuilder `ans`.
     *  2. For each index i from 0 to n−1:
     *       - Read bit = nums[i].charAt(i)
     *       - Invert the bit: '0' → '1', '1' → '0'
     *       - Append it to the answer.
     *  3. Return ans.toString().
     *
     * Time Complexity:  O(n)
     * Space Complexity: O(n) (for the output string)
     *
     * @param nums array of n distinct binary strings, each of length n
     * @return a binary string of length n that does not appear in nums
     */
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            char inverted = nums[i].charAt(i) == '0' ? '1' : '0';
            sb.append(inverted);
        }

        return sb.toString();
    }



    /**
     * LeetCode 1980 — Find Unique Binary String
     *
     * Problem:
     *  Given an array of n distinct binary strings, each of length n,
     *  return a binary string of length n that does not appear in the array.
     *
     * Key Idea (Cantor’s Diagonalization with XOR):
     *  - Build a new binary string by taking the i-th bit from nums[i].
     *  - Flip that bit using XOR with 1:  (bit ^ 1)
     *       '0' → 0,  0 ^ 1 = 1 → '1'
     *       '1' → 1,  1 ^ 1 = 0 → '0'
     *  - This new string differs from nums[i] in position i,
     *    ensuring it cannot equal any of the given strings.
     *
     * Example:
     *   nums = ["010", "100", "001"]
     *   Diagonal bits: [0, 0, 1]
     *   Inverted bits (XOR 1): [1, 1, 0]
     *   Result = "110"  → not present in nums → valid answer.
     *
     * Algorithm:
     *  1. Initialize an empty StringBuilder `ans`.
     *  2. For each index i from 0 to n−1:
     *       - Convert nums[i].charAt(i) to an integer bit (0 or 1).
     *       - Invert it using XOR with 1.
     *       - Append the inverted bit to `ans`.
     *  3. Return the built string.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n) (for the output string)
     *
     * @param nums array of n distinct binary strings of equal length n
     * @return a binary string of length n that does not appear in nums
     */
    public String findDifferentBinaryStringXor(String[] nums) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            int bit = nums[i].charAt(i) - '0'; // '0'→0, '1'→1
            ans.append(bit ^ 1);               // flip bit with XOR 1
        }

        return ans.toString();
    }

}