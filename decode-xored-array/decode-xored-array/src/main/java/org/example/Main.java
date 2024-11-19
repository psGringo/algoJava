package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    /**
     * arr[i+1] = encoded[i] XOR arr[i]
     *
     * @param encoded
     * @param first
     * @return
     */
    public int[] decode(int[] encoded, int first) {

        List<Integer> res = new ArrayList<>();
        res.add(first);
        int decoded = first;
        for (int i = 0; i < encoded.length; i++) {
            int n = encoded[i] ^ decoded;
            res.add(n);
            decoded = n;
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

}