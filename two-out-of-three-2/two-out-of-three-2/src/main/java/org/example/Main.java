package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/two-out-of-three/
 */
public class Main {
    public static void main(String[] args) {

    }

    private boolean[] b1 = new boolean[100];
    private boolean[] b2 = new boolean[100];
    private boolean[] b3 = new boolean[100];

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            b1[nums1[i]] = true;
        }
        for (int i = 0; i < nums2.length; i++) {
            b2[nums2[i]] = true;
        }
        for (int i = 0; i < nums3.length; i++) {
            b3[nums3[i]] = true;
        }

        for (int i = 1; i <= 100; i++) {
            if ((b1[i] && b2[i]) || (b1[i] && b3[i]) || (b2[i] && b3[i])) {
                list.add(i);
            }
        }

        return list;
    }

}