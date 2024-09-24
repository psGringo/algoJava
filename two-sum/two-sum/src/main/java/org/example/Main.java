package org.example;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {

        Num[] numArr = new Num[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numArr[i] = new Num(nums[i], i);
        }

        Arrays.sort(numArr, (o1, o2) -> {
            if (o1.value() > o2.value()) {
                return 1;
            } else if (o1.value() < o2.value()) {
                return -1;
            } else {
                return 0;
            }
        });
        int[] result = new int[2];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = numArr[left].value() + numArr[right].value();
            if (sum == target) {
                result[0] = numArr[left].index();
                result[1] = numArr[right].index();
                return result;
            } else if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            }
        }

        return result;
    }

}