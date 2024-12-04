package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/description/
 */
public class Main {
    public static void main(String[] args) {
        findXSum(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2);
    }

    public static int[] findXSum(int[] nums, int k, int x) {
        int i = 0;
        int j = k - 1;
        List<Integer> res = new ArrayList<>();

        int fullSum = 0;
        for (int z = 0; z < nums.length; z++) {
            fullSum += nums[z];
        }

        while (j < nums.length) {
            int xSum = getXSum(nums, i, j, x, fullSum);
            res.add(xSum);
            i++;
            j++;
        }

        return res.stream().mapToInt(i1 -> i1).toArray();
    }

    private static int getXSum(int[] nums, int i, int j, int x, int fullSum) {

        // to implement

        int[] fq = new int[52];
        for (int k = i; k <= j; k++) {
            fq[nums[k]]++;
        }

        int countDifferentElements = 0;
        for (int k = 0; k < fq.length; k++) {
            if (fq[k] > 0) {
                countDifferentElements++;
            }
        }

        if (nums.length < countDifferentElements) {
            return fullSum;
        }

        PriorityQueue<NumInfo> pq = new PriorityQueue<>((x1, y1) -> {
            int diff = y1.frequency() - x1.frequency();
            if (diff == 0) {
                return y1.num() - x1.num();
            } else {
                return diff;
            }
        });
        for (int k = 0; k < fq.length; k++) {
            pq.add(new NumInfo(k, fq[k]));
        }

        int sum = 0;
        int count = 0;
        while (!pq.isEmpty() && count < x) {
            NumInfo numInfo = pq.poll();
            sum += numInfo.num() * numInfo.frequency();
            count++;
        }
        return sum;
    }
}

record NumInfo(int num, int frequency) {
}