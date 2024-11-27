package org.example;


/**
 * https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/description/
 */
public class Main {
    public static void main(String[] args) {
        minimumOperations(new int[]{1, 5, 0, 3, 5});
    }

    /**
     * could use set here, but frequencies are faster
     *
     * @param nums
     * @return
     */
    public static int minimumOperations(int[] nums) {
        int[] fq = new int[101];
        int count = 0;

        for (int num : nums) {
            if (num !=0 && fq[num] == 0) {
                count++;
            }
            fq[num]++;
        }
        return count;
    }
}
