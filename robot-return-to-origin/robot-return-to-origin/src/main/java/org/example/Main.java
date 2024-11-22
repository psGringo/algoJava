package org.example;


/**
 * https://leetcode.com/problems/robot-return-to-origin/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean judgeCircle(String moves) {
        int countHorizontalMovements = 0;
        int countVerticalMovements = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'L') {
                countHorizontalMovements--;
            } else if (moves.charAt(i) == 'R') {
                countHorizontalMovements++;
            } else if (moves.charAt(i) == 'U') {
                countVerticalMovements++;
            } else if (moves.charAt(i) == 'D') {
                countVerticalMovements--;
            }
        }

        return countHorizontalMovements == 0 && countVerticalMovements == 0;
    }
}