package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/roman-to-integer/description/
 */
public class Main {

    public static void main(String[] args) {
        romanToIntBrute("III");
    }

    /**
     * roman numeration is decreasing numbers from left to right except IV, XL..., they are increasing
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        int cur = 0;
        int prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            cur = map.get(s.charAt(i));
            if (cur < prev) {
                sum -= cur;
            } else {
                sum += cur;
            }

            prev = cur;
        }

        return sum;
    }

    /**
     * brute force approach
     *
     * @param s
     * @return
     */
    public static int romanToIntBrute(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1) {
                if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') {
                    sum += map.get("IV");
                    i++;
                } else if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') {
                    sum += map.get("IX");
                    i++;
                } else if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') {
                    sum += map.get("XL");
                    i++;
                } else if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') {
                    sum += map.get("XC");
                    i++;
                } else if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') {
                    sum += map.get("CD");
                    i++;
                } else if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {
                    sum += map.get("CM");
                    i++;
                } else {
                    sum += map.get(Character.toString(s.charAt(i)));
                }
            } else {
                sum += map.get(Character.toString(s.charAt(i)));
            }
        }
        return sum;
    }

}