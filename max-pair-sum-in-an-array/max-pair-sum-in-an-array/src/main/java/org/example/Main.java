package org.example;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        maxSum(new int[]{2536, 1613, 3366, 162});
    }

    public static int maxSum(int[] nums) {

        PriorityQueue<NumInfo> pq = new PriorityQueue<>((x, y) -> x.maxDigit() - y.maxDigit());
        for (int i = 0; i < nums.length; i++) {
            pq.add(new NumInfo(nums[i], getMaxDigit(nums[i])));
        }


        int max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            NumInfo numInfo = pq.poll();
            list.add(numInfo.num());
            if (pq.isEmpty() || pq.peek().maxDigit() != numInfo.maxDigit()) {
                int[] arr = list.stream().mapToInt(i -> i).toArray();
                max = Math.max(max, getMaxOfPairs(arr));
                list.clear();
            }
        }

        return max == Integer.MIN_VALUE ? -1 : max;
    }

    private static int getMaxOfPairs(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[i] + nums[j]);
            }
        }

        return max;
    }

    private static int getMaxDigit(int num) {
        int max = Integer.MIN_VALUE;
        while (num > 0) {
            int remainder = num % 10;
            max = Math.max(max, remainder);
            num = num / 10;
        }
        return max;
    }
}

record NumInfo(int num, int maxDigit) {
}