package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-the-students-by-their-kth-score/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     * my first solution
     *
     * @param score
     * @param k
     * @return
     */
    public int[][] sortTheStudents(int[][] score, int k) {
        // Sort the 2D array in-place based on the kth column in descending order
        Arrays.sort(score, (a, b) -> Integer.compare(b[k], a[k]));
        return score; // Return the sorted array
    }


    /**
     * my first solution
     *
     * @param score
     * @param k
     * @return
     */
    public int[][] sortTheStudents1(int[][] score, int k) {
        Student[] students = new Student[score.length];
        for (int i = 0; i < score.length; i++) {
            students[i] = new Student(i, score[i][k]);
        }
        Arrays.sort(students, (x,y) -> y.score() - x.score());

        int[][] result = new int[score.length][score[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = score[students[i].newIndex()][j];
            }
        }

        return result;
    }
}

record Student(int newIndex, int score) {
}