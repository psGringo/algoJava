package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public int returnToBoundaryCount(int[] nums) {
        int startPosition = 0;
        int currPosition = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            currPosition += nums[i];
            if (currPosition == startPosition) {
                count++;
            }
        }
        return count;
    }
}