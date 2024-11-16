package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-senior-citizens/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int countSeniors(String[] details) {
        return (int) Arrays.stream(details).filter((pass) -> {
            int age = Integer.parseInt(pass.substring(11, 13));
            System.out.println(age);
            return age >= 60;
        }).count();
    }
}