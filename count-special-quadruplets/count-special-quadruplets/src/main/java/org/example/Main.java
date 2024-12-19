package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/count-special-quadruplets/description/
 */
public class Main {
    public static void main(String[] args) {
        countQuadruplets(new int[]{1, 1, 1, 3, 5});
    }

    public static int countQuadruplets(int[] nums) {
        HashMap<Integer, List<NumInfo>> map = new HashMap<>();
        for (int c = 0; c < nums.length; c++) {
            for (int d = c + 1; d < nums.length; d++) {
                int num = nums[d] - nums[c];
                if (map.containsKey(num)) {
                    List<NumInfo> list = map.get(num);
                    list.add(new NumInfo(c, d, num));
                } else {
                    List<NumInfo> list = new ArrayList<>();
                    list.add(new NumInfo(c, d, num));
                    map.put(num, list);
                }
            }
        }

        int count = 0;
        for (int a = 0; a < nums.length; a++) {
            for (int b = a + 1; b < nums.length; b++) {
                int num = nums[a] + nums[b];
                if (map.containsKey(num)) {
                    List<NumInfo> list = map.get(num);
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).c() > b) {
                            count++;
                        }
                    }

                }
            }
        }

        return count;
    }
}

record NumInfo(int c, int d, int num) {
}