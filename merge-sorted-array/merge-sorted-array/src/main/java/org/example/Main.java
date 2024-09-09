package org.example;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        int m = 0;
        int n = 1;
        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tempArray = new int[m + n];
        int indexLeft = 0;
        int indexRight = 0;

        if (n == 0) {
            System.arraycopy(nums1, 0, nums2, 0, nums2.length);
            return;
        }

        if (m == 0 && n > 0) {
            nums1 = new int[n];
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
            System.out.println("here %s".formatted(nums1[0]));
            return;
        }

        int min = Math.min(m, n);
        int k = 0;

        while (true) {
            if (indexLeft >= min || indexRight >= min) {
                break;
            }

            if (nums1[indexLeft] < nums2[indexRight]) {
                tempArray[k] = nums1[indexLeft];
                k++;
                indexLeft++;
            } else if (nums1[indexLeft] == nums2[indexRight]) {
                tempArray[k] = nums1[indexLeft];
                tempArray[++k] = nums2[indexRight];
                k++;
                indexLeft++;
                indexRight++;
            }
            else if (nums1[indexLeft] > nums2[indexRight]) {
                tempArray[k] = nums2[indexLeft];
                k++;
                indexRight++;
            }
        }

        System.out.println("here");

        if (indexLeft + 1 < min) {
            for (int i = indexLeft; i < nums1.length; i++) {
                tempArray[++k] = nums1[indexLeft];
                indexLeft++;
            }
        }

        if (indexRight + 1 < min) {
            for (int i = indexRight; i < nums2.length; i++) {
                tempArray[k++] = nums2[indexRight];
                indexRight++;
            }
        }

        System.arraycopy(tempArray, 0, nums1, 0, tempArray.length);
    }
}