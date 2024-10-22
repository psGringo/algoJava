package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-indices-of-stable-mountains/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> mountains = new ArrayList<>();
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold) {
                mountains.add(i);
            }
        }
        return mountains;
    }
}