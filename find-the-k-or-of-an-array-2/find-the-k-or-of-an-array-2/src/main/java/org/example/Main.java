package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        findKOr(new int[]{7, 12, 9, 8, 9, 15}, 4);
    }

    public static int findKOr(int[] nums, int k) {
        int[] fq = new int[31];
        for (int num : nums) {
            for (int i = 0; i <= 31; i++) {
                int bitResult = (num >> i) & 1;
                if (bitResult == 1) {
                    fq[i]++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < fq.length; i++) {
            if (fq[i] >= k) {
                res += Math.pow(2, i);
            }
        }

        return res;
    }
}