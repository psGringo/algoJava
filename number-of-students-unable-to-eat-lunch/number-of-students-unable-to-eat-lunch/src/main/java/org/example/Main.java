package org.example;


import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/
 */
public class Main {
    public static void main(String[] args) {
        countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1});
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Student> studentsQueue = new LinkedList<>();
        for (int i = 0; i < students.length; i++) {
            studentsQueue.add(new Student(i, students[i]));
        }

        Stack<Integer> sandwichesStack = new Stack<>();
        for (int i = sandwiches.length - 1; i >= 0 ; i--) {
            sandwichesStack.push(sandwiches[i]);
        }

        int count = 0;

        while (!studentsQueue.isEmpty() && !sandwichesStack.isEmpty() && count < studentsQueue.size()) {
            if (studentsQueue.peek().getPreference() == sandwichesStack.peek()) {
                sandwichesStack.pop();
                studentsQueue.poll();
                count = 0;
            } else {
                Student student = studentsQueue.poll();
                studentsQueue.add(student);
                count++;
            }
        }

        return studentsQueue.size();
    }


    static class Student {
        private int index;
        private int preference;

        public Student(int index, int preference) {
            this.index = index;
            this.preference = preference;
        }

        public int getIndex() {
            return index;
        }

        public int getPreference() {
            return preference;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setPreference(int preference) {
            this.preference = preference;
        }
    }

}