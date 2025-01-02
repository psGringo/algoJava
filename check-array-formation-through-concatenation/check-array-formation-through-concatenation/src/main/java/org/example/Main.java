package org.example;


import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/check-array-formation-through-concatenation/description/
 */
public class Main {
    public static void main(String[] args) {
//        int[] arr = {91, 4, 64, 78};
//        int[][] pieces = new int[][]{{78}, {4, 64}, {91}};
        int[] arr = {49, 18, 16};
        int[][] pieces = {{16, 18, 49}};

        canFormArray(arr, pieces);
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int[] piece : pieces) {
            int index = -1;
            if (!map.containsKey(piece[0])) {
                return false;
            } else {
                index = map.get(piece[0]);
            }

            if (arr.length - 1 - index < piece.length) {
                return false;
            }

            for (int j = 1; j < piece.length; j++) {
                if (piece[j] != arr[++index]) {
                    return false;
                }
            }
        }

        return true;
    }


// this approach doesnt work

//    HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < pieces.length; i++) {
//        for (int j = 0; j < pieces[i].length; j++) {
//            set.add(pieces[i][j]);
//        }
//    }
//
//        for (int num : arr) {
//        if (!set.contains(num)) {
//            return false;
//        }
//    }
//        return true;
}