package org.example;


import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};

        int[] res = smallerNumbersThanCurrentHashMapApproach(nums);
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        final int kMax = 100;
        int[] ans = new int[nums.length];
        int[] count = new int[kMax + 1];

        // frequency
        for (final int num : nums)
            ++count[num];

        // cumulative frequency
        for (int i = 1; i <= kMax; ++i)
            count[i] += count[i - 1];

        // result, prev count is count of nums
        for (int i = 0; i < nums.length; ++i)
            ans[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];

        return ans;
    }

    public static int[] smallerNumbersThanCurrentHashMapApproach(int[] nums) {
        Num[] numsRecArr = new Num[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsRecArr[i] = new Num(nums[i], i);
        }


        // sort in backward direction
        Arrays.sort(numsRecArr, (x, y) -> {
            if (x.value() > y.value()) {
                return -1;
            } else if (x.value() < y.value()) {
                return 1;
            }
            return 0;
        });


        HashMap<Integer, Integer> dublicatesMap = getDublicatesMap(numsRecArr);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numsRecArr.length; i++) {
            map.put(numsRecArr[i].index(), numsRecArr.length - i - 1 - dublicatesMap.get(i));
        }

        int[] res = new int[nums.length];
        var entry = map.entrySet().iterator();
        while (entry.hasNext()) {
            var pair = entry.next();
            res[pair.getKey()] = pair.getValue();
        }
        return res;
    }

    private static HashMap<Integer, Integer> getDublicatesMap(Num[] numsRecArr) {
        HashMap<Integer, Integer> dublicatesMap = new HashMap<>();
        dublicatesMap.put(numsRecArr.length - 1, 0);
        for (int i = numsRecArr.length - 2; i >= 0 ; i--) {
            if (numsRecArr[i].value() == numsRecArr[i + 1].value()) {
                int countDublicates = 1 + dublicatesMap.get(i + 1);
                dublicatesMap.put(i, countDublicates);
            } else {
                dublicatesMap.put(i, 0);
            }
        }
        return dublicatesMap;
    }

}

record Num(int value, int index) {
}