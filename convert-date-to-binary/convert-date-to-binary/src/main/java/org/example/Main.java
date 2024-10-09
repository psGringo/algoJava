package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String res = convertDateToBinary("2080-02-29");
    }

    public static String convertDateToBinary(String date) {
        String[] splitted = date.split("-");
        String[] binary = new String[splitted.length];
        for (int i = 0; i < splitted.length; i++) {
            binary[i] = toBinary(Integer.parseInt(splitted[i]));
        }
        return String.join("-", binary);
    }



    private static String toBinary(int num) {
        Stack<Integer> stack = new Stack<>();
        while (num > 0) {
            stack.push(num % 2);
            num = num / 2;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

}