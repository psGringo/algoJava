package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/count-hills-and-valleys-in-an-array/description/
 */
public class Main {
    public static void main(String[] args) {
        countHillValley(new int[]{6, 6, 5, 5, 4, 1});
    }

    public static int countHillValley(int[] nums) {
        List<Integer> nonRepeatingNums = new ArrayList<>();
        int prevNum = nums[0];
        nonRepeatingNums.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (prevNum == nums[i]) {
                continue;
            } else {
                nonRepeatingNums.add(nums[i]);
                prevNum = nums[i];
            }
        }
        int[] nonRepeatingNumsArr = nonRepeatingNums.stream().mapToInt(i -> i).toArray();
        int countHillValley = 0;
        for (int i = 1; i < nonRepeatingNumsArr.length - 1; i++) {
            boolean isHill = nonRepeatingNumsArr[i] > nonRepeatingNumsArr[i - 1] && nonRepeatingNumsArr[i] > nonRepeatingNumsArr[i + 1];
            boolean isValley = nonRepeatingNumsArr[i] < nonRepeatingNumsArr[i - 1] && nonRepeatingNumsArr[i] < nonRepeatingNumsArr[i + 1];
            if (isHill || isValley) {
                countHillValley++;
            }
        }

        return countHillValley;
    }

    /**
     * more optimal solution
     *
     * @param nums
     * @return
     */
    public int countHillValley2(int[] nums) {

        int c=0, left =nums[0];
        for(int i=1; i<=nums.length-2; i++){
            if( (left<nums[i] && nums[i]>nums[i+1]) || (left>nums[i] && nums[i]<nums[i+1]) ){
                c++;
                left=nums[i];
            }
        }
        return c;
    }
}