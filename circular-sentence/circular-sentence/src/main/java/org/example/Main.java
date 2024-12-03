package org.example;


import java.util.Stack;

public class Main {
    public static void main(String[] args) {

    }

    public boolean isCircularSentence(String sentence) {
        Stack<Character> stack = new Stack<>();
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            stack.push(words[i].charAt(0));
            stack.push(words[i].charAt(words[i].length() - 1));
        }

        char lastInSentence = stack.pop();
        while (stack.size() > 1) {
            char firstLetterOfTheWord = stack.pop();
            char secondLetterOfTheWord = stack.pop();
            if (firstLetterOfTheWord != secondLetterOfTheWord) {
                return false;
            }
        }
        char firstLetterInSentence = stack.pop();

        return firstLetterInSentence == lastInSentence;
    }
}