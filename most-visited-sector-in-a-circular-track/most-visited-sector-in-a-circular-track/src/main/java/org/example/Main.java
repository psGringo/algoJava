package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public void calc(int a, int b, List<Integer> l) {
        for (int i = a; i <= b; i++) {
            l.add(i);
        }
    }

    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> list = new ArrayList<>();
        int a = rounds[0];
        int b = rounds[rounds.length - 1];
        if (a <= b) {
            calc(a, b, list);
        } else {
            calc(1, b, list);
            calc(a, n, list);
        }
        return list;
    }

}