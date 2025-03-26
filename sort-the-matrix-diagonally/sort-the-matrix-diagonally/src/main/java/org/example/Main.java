package org.example;


import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

    }

    /**
     * my decision
     *
     * @param mat
     * @return
     */
    public int[][] diagonalSort(int[][] mat) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int diagonalId = i - j;
                var pq = map.get(diagonalId);
                if (pq == null) { // could be optimized with  map.computeIfAbsent(diagId, k -> new PriorityQueue<>()).add(mat[i][j]);
                    pq = new PriorityQueue<>();
                    pq.add(mat[i][j]);
                    map.put(diagonalId, pq);
                } else {
                    pq.add(mat[i][j]);
                }
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int diagonalId = i - j;
                var pq = map.get(diagonalId);
                mat[i][j] = pq.poll();
            }
        }

        return mat;
    }
}