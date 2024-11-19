package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/description/
 */
public class Main {
    public static void main(String[] args) {
        int[] res = getFinalState(new int[]{2, 1, 3, 5, 6}, 5, 2);
    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<NumInfo> pq = new PriorityQueue<>((x, y) -> {
            if (x.num() == y.num()) {
                return x.originIndex() - y.originIndex();
            }
            return x.num() - y.num();
        });
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new NumInfo(nums[i], i));
        }

        // do the main job...
        for (int i = 0; i < k; i++) {
            NumInfo num = pq.poll();
            pq.offer(new NumInfo(num.num() * multiplier, num.originIndex()));
        }

        // sort in previous order by origin index
        NumInfo[] res = new NumInfo[pq.size()];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll();
        }
        Arrays.sort(res, (x, y) -> x.originIndex() - y.originIndex());

        // preparing result
        List<Integer> list = new ArrayList<>();
        for (NumInfo num : res) {
            list.add(num.num());
        }

        return list.stream().mapToInt(x -> x).toArray();
    }
}

record NumInfo(int num, int originIndex) {
}