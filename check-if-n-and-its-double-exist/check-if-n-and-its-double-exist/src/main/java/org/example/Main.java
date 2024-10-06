package org.example;


import java.util.Arrays;
import java.util.HashSet;

/**
 * [ARRAYS, BINARY SEARCH, HASHSET]
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
 */
public class Main {
    public static void main(String[] args) {
        checkIfExistBinary(new int[]{10, 2, 5, 3});
    }


    private boolean checkIfExistsHashSet(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(2 * arr[i]) || (arr[i] % 2 == 0 && set.contains(arr[i] / 2))) {
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }

    private boolean checkIfExistBrute(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == 2 * arr[j] && i != j) {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean checkIfExistBinary(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            boolean res = doCheckIfExistBinary(arr, 0, arr.length - 1, i);
            if (res) {
                return true;
            }
        }
        return false;
    }


    private static boolean doCheckIfExistBinary(int[] arr, int lo, int hi, int index) {
        int target = 2 * arr[index];
        int mid = lo + (hi - lo) / 2;
        if (lo > hi) {
            return false;
        }
        if (arr[mid] == target && mid != index) {
            return true;
        } else if (arr[mid] < target) {
            return doCheckIfExistBinary(arr, mid + 1, hi, index);
        } else if (arr[mid] > target) {
            return doCheckIfExistBinary(arr, lo, mid - 1, index);
        }
        return false;
    }

}