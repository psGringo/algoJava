package org.example;


/**
 * https://leetcode.com/problems/valid-perfect-square/description/
 */
public class Main {
    public static void main(String[] args) {
        isPerfectSquare(808201);
//        isPerfectSquare2(808201);
    }

    public static boolean isPerfectSquare(int num) {

        if (num == 1) {
            return true;
        }

        return doIsPerfectSquare(num, 0, num / 2);
    }

    /**
     * Pay attention that params here are long
     *
     * @param num
     * @param lo
     * @param hi
     * @return
     */
    public static boolean doIsPerfectSquare(int num, long lo, long hi) {
        if (hi < lo) {
            return false;
        }

        long mid = (lo + hi) / 2;

        if (mid * mid == num) {
            return true;
        } else if (mid * mid < num) {
            return doIsPerfectSquare(num, mid + 1, hi);
        } else if (mid * mid > num) {
            return doIsPerfectSquare(num, lo, mid - 1);
        }
        return false;
    }

    public static boolean isPerfectSquare2(int num) {

        if(num==1)
            return true;

        long low = 0, high = num / 2;

        while (low <= high) {

            long mid = (low + high) / 2;

            if ((mid * mid) == num)
                return true;

            else if ((mid * mid) < num)
                low = mid + 1;

            else if ((mid * mid) > num)
                high = mid - 1;
        }
        return false;
    }


}