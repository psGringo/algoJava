package org.example;


/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 */
public class Main {
    public static void main(String[] args) {
        char res = nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c');
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int index = binarySearch(letters, (int) target, 0, letters.length - 1);
        return index == -1 ? letters[0] : letters[index];
    }

    private static int binarySearch(char[] letters, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if ((int) letters[mid] > target) {
                hi = mid - 1;  // for [lo, hi] || hi = mid for [lo, hi)
            } else {
                lo = mid + 1;
            }
        }

        if (lo >= 0 && lo < letters.length && letters[lo] > target) {
            return lo;
        }

        return -1; // Returns <hi + 1> if not found
    }
}