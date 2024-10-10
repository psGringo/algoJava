package org.example;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var res = isHappy(19);
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet();

        while (true) {
            List<Integer> nums = getNums(n);
            int sum = calcSquareSum(nums);
            if (sum == 1) {
                return true;
            } else if (set.contains(sum)) {
                return false;
            } else {
                n = sum;
                set.add(sum);
            }
        }

    }

    private static List<Integer> getNums(Integer n) {
        List<Integer> res = new ArrayList<>();
        String numsString = Integer.toString(n);
        for (int i = 0; i < numsString.length(); i++) {
            res.add(Character.getNumericValue(numsString.charAt(i)));
        }
        return res;
    }

    private static int calcSquareSum(List<Integer> nums) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += Math.pow(nums.get(i), 2);
        }
        return sum;
    }

}