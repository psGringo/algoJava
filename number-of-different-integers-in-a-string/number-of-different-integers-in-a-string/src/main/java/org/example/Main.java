package org.example;


import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-different-integers-in-a-string/description/
 */
public class Main {
    public static void main(String[] args) {
        numDifferentIntegers("a123bc34d8ef34");
    }

    public static int numDifferentIntegers(String word) {

        String[] nums = word.replaceAll("[^0-9]", " ").split(" ");
        Set<String> set = new HashSet<>();
        for (String num : nums) {

            if (num.matches("[0-9]+")) {
                int i = 0;
                for (i = 0; i < num.length(); i++) {
                    if (num.charAt(i) == '0') {
                        continue;
                    } else {
                        break;
                    }
                }

                set.add(num.substring(i));
            }

        }
        return set.size();
    }
}