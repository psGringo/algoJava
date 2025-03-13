package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10);
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        int index = 0;

        for (int num : nums) {
            if (num < pivot) {
                res[index++] = num;
            }
        }

        for (int num : nums) {
            if (num == pivot) {
                res[index++] = num;
            }
        }

        for (int num : nums) {
            if (num > pivot) {
                res[index++] = num;
            }
        }

        return res;
    }


    public static int[] pivotArrayWithLists(int[] nums, int pivot) {

        List<Integer> listLess = new ArrayList<>();
        List<Integer> listEqual = new ArrayList<>();
        List<Integer> listMore = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
               listLess.add(nums[i]);
            }
            if (nums[i] == pivot) {
                listEqual.add(nums[i]);
            }
            if (nums[i] > pivot) {
                listMore.add(nums[i]);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < listLess.size(); i++) {
            result.add(listLess.get(i));
        }
        for (int i = 0; i < listEqual.size(); i++) {
            result.add(listEqual.get(i));
        }
        for (int i = 0; i < listMore.size(); i++) {
            result.add(listMore.get(i));
        }

        return result.stream().mapToInt(i -> i).toArray();
    }


}