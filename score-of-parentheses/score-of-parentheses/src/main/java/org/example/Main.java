package org.example;


import java.util.Stack;

/**
 * https://leetcode.com/problems/score-of-parentheses/description/
 */
public class Main {
    public static void main(String[] args) {
        scoreOfParentheses("(()(()))");
    }

    /**
     * example
     * <p>
     * ( () ( () ) )
     * = ( 1 + ( 1 ) )
     * = ( 1 + 2 * 1 )
     * = ( 3 )
     * = 2 * 3
     * = 6
     *
     * @param s
     * @return
     */
    public static int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(score);
                score = 0;
            } else if (s.charAt(i) == ')') {
                score = stack.pop() + (score == 0 ? 1 : 2 * score);
            }
        }

        return score;
    }

}