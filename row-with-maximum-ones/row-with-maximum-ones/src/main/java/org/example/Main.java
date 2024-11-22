package org.example;


import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[] res = rowAndMaximumOnes(new int[][]{{0, 1}, {1, 0}});
    }

    public static int[] rowAndMaximumOnes(int[][] mat) {
        PriorityQueue<RowInfo> pq = new PriorityQueue<>((x, y) ->
                x.rowNumber() - y.rowNumber()
        );

        int max = Integer.MIN_VALUE;
        for (int row = 0; row < mat.length; row++) {
            int count = 0;
            for (int col = 0; col < mat[row].length; col++) {
                if (mat[row][col] == 1) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
                pq.clear();
                pq.offer(new RowInfo(row, max));
            } else if (count == max) {
                pq.add(new RowInfo(row, max));
            }
        }

        //
        RowInfo rowInfo = pq.poll();
        return new int[]{rowInfo.rowNumber(), rowInfo.countOnes()};
    }


}

record RowInfo(int rowNumber, int countOnes) {
}

