package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        createTargetArray(new int[]{0,1,2,3,4}, new int[]{0,1,2,2,1});
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }

        int[] targetArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            targetArray[i] = list.get(i);
        }

        return targetArray;
    }
}