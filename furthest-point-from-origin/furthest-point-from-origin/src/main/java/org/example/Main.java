package org.example;


/**
 * https://leetcode.com/problems/furthest-point-from-origin/description/
 */
public class Main {
    public static void main(String[] args) {
        furthestDistanceFromOrigin("L_RL__R");
    }

    public static int furthestDistanceFromOrigin(String moves) {
        int countL = 0;
        int countR = 0;
        int count_ = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                countL++;
            }
            if (c == 'R') {
                countR++;
            }
            if (c == '_') {
                count_++;
            }
        }

        if (countR >= countL) {
            return countR - countL + count_;
        } else {
            return countL - countR + count_;
        }
    }
}