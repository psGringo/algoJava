package org.example;


import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        countGoodSubstrings("aababcabc");
    }

    public static int countGoodSubstrings(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i <= chars.length - 3; ++i) {
            if (chars[i] != chars[i + 1] && chars[i + 1] != chars[i + 2] && chars[i] != chars[i + 2]) {
                ++count;
            }
        }
        return count;
    }

    public static int countGoodSubstrings2(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            set.clear();
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1 == 3) {
                    for (int k = i; k <= j; k++) {
                        set.add(s.charAt(k));
                    }
                    System.out.println(sb.toString());
                    if (set.size() == 3) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

}