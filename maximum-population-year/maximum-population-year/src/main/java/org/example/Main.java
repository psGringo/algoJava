package org.example;


import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[][] logs = new int[][]{{1950, 1961}, {1960, 1971}, {1970, 1981}};
        maximumPopulation(logs);
    }

    public static int maximumPopulation(int[][] logs) {
        int minYear = Integer.MAX_VALUE;
        int maxYear = Integer.MIN_VALUE;
        for (int i = 0; i < logs.length; i++) {
            for (int j = 0; j < logs[i].length; j++) {
                minYear = Math.min(minYear, logs[i][j]);
                maxYear = Math.max(maxYear, logs[i][j]);
            }
        }

        PriorityQueue<YearInfo> pq = new PriorityQueue<>((x, y) -> {
            if (x.count() != y.count()) {
                return y.count() - x.count();
            } else {
                return x.year() - y.year();
            }
        });

        for (int year = minYear; year <= maxYear; year++) {
            int count = 0;
            for (int i = 0; i < logs.length; i++) {
                if (year >= logs[i][0] && year < logs[i][1]) {
                    count++;
                }
            }
            pq.add(new YearInfo(year, count));
        }

        return pq.peek().year();
    }
}

record YearInfo(int year, int count) {
}