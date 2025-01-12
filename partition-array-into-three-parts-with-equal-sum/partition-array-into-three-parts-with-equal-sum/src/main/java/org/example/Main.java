package org.example;


/**
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/description/
 */
public class Main {
    public static void main(String[] args) {
        canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1});
    }

    public static boolean canThreePartsEqualSum(int[] arr) {
        int totalSum = 0;

        // Calculate the total sum of the array
        for (int num : arr) {
            totalSum += num;
        }

        // If the total sum is not divisible by 3, it's impossible to partition
        if (totalSum % 3 != 0) {
            return false;
        }

        int target = totalSum / 3;
        int leftSum = 0;
        int rightSum = 0;
        int left = 0;
        int right = arr.length - 1;

        // Find the left partition with sum equal to target
        while (left < arr.length) {
            leftSum += arr[left];
            if (leftSum == target) {
                break;
            }
            left++;
        }

        // Find the right partition with sum equal to target
        while (right > left) {
            rightSum += arr[right];
            if (rightSum == target) {
                break;
            }
            right--;
        }

        // should be at least one element in the middle
        return right - left > 1;
    }

}