package org.example;


/**
 * https://leetcode.com/problems/first-bad-version/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int firstBadVersionIterative(int n) {
        int lo = 1; int hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (lo >=1 && lo <= n && isBadVersion(lo)) {
            return lo;
        }

        return -1;
    }

    public int firstBadVersionRecursive(int n, int lo, int hi) {
        return firstBadVersionRecursive(n, lo, hi);
    }

    private int doFirstBadVersionRecursive(int n, int lo, int hi) {
        if (lo >= hi) {
            if (lo >=1 && lo <= n && isBadVersion(lo)) {
                return lo;
            }

            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (isBadVersion(mid)) {
            return doFirstBadVersionRecursive(n, lo, mid - 1);
        } else {
            return doFirstBadVersionRecursive(n, mid + 1, hi);
        }
    }

    private boolean isBadVersion(int n) {
        return true;
    }
}