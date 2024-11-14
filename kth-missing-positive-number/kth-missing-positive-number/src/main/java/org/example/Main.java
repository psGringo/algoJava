package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/kth-missing-positive-number
 */
public class Main {
    public static void main(String[] args) {
        findKthPositiveBinary(new int[]{1, 2, 3, 4}, 2);
    }

    public static int findKthPositiveBinary(int[] arr, int k) {
        return binarySearch(arr, k);
    }

    /**
     * hint:
     * countMissed = arr[index] - (index + 1); // to the left
     *
     */
    private static int binarySearch(int[] arr, int k) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int countMissed = arr[mid] - (mid + 1);
            if (countMissed >= k) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        if (lo >= 0 && hi < arr.length) {
            return lo + k;
        }

        return -1;
    }

    public static int findKthPositiveLinear(int[] arr, int k) {
        List<Integer> missedNums = new ArrayList<>();
        int index = 0;
        int currNum = 1;
        while (index < arr.length) {
            if (arr[index] != currNum) {
                missedNums.add(currNum);
                currNum++;
            } else {
                currNum++;
                index++;
            }
            if (missedNums.size() == k) {
                break;
            }
        }
        //if empty arr
        while (missedNums.size() != k) {
            missedNums.add(currNum++);
        }

        return missedNums.get(k - 1);
    }

}