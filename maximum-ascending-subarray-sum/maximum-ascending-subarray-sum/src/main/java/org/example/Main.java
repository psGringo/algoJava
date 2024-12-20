package org.example;


import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        maxAscendingSum(new int[]{10, 20, 30, 40, 50});
    }

    public static int maxAscendingSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                pq.add(sum);
                sum = nums[i];
            }
            // last set of nums
            if (i == nums.length - 1) {
                pq.add(sum);
            }
        }
        return pq.peek();
    }
}