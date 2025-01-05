package org.example;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args)
    {
       secondHighest("dfa12321afd");
    }

    public static int secondHighest(String s) {
        Set<Integer> set = new TreeSet<>((x, y) -> y - x);
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                set.add(Character.digit(c, 10));
            }
        }

        if (set.size() <= 1) {
            return -1;
        }

        var iterator = set.iterator();
        iterator.next(); // first

        return iterator.next(); // second
    }
}