package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }

    /**
     *
     * ✅ Replaced Math.pow(x, 2) with x * x → Much faster integer operations.
     * ✅ Avoided Math.sqrt() by comparing squared distances → Better precision & performance.
     * ✅ Reduced redundant computations (pre-compute squared radius) → Fewer multiplications inside loop.
     *
     * @param points
     * @param queries
     * @return
     */
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] counts = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int centerX = queries[i][0];
            int centerY = queries[i][1];
            int radiusSquared = queries[i][2] * queries[i][2]; // Avoid Math.pow()

            for (int j = 0; j < points.length; j++) {
                int dx = points[j][0] - centerX;
                int dy = points[j][1] - centerY;

                // Avoid Math.sqrt() - Use squared comparison
                if (dx * dx + dy * dy <= radiusSquared) {
                    counts[i]++;
                }
            }
        }
        return counts;
    }

}