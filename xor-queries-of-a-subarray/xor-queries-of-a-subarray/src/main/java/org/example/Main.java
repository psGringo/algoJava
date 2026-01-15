package org.example;


public class Main {
    public static void main(String[] args) {

    }

    /**
     * Computes the XOR of elements for multiple subarray range queries.
     *
     * <p>The algorithm uses a prefix XOR array where each element stores the XOR
     * of all values before a given index. This allows each range query to be
     * answered in constant time.</p>
     *
     * <p>Prefix definition:
     * <pre>
     * px[0] = 0
     * px[i] = arr[0] ^ arr[1] ^ ... ^ arr[i - 1]
     * </pre>
     *
     * <p>For a query {@code [L, R]}, the XOR of the subarray {@code arr[L..R]} is:
     * <pre>
     * px[R + 1] ^ px[L]
     * </pre>
     *
     * <p>This works because XOR is its own inverse: values appearing twice cancel
     * out, removing the prefix {@code arr[0..L-1]} and leaving only the desired
     * range.</p>
     *
     * <h3>Complexity</h3>
     * <ul>
     *   <li>Time: {@code O(n + q)}, where {@code n} is the array length and
     *       {@code q} is the number of queries</li>
     *   <li>Space: {@code O(n)} for the prefix XOR array</li>
     * </ul>
     *
     * @param arr the input array of integers
     * @param queries a 2D array where each query is {@code [L, R]} (inclusive)
     * @return an array containing the XOR result for each query
     */
    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] px = new int[arr.length +1];
        px[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            px[i+1] = px[i] ^ arr[i];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            res[i] = px[r+1] ^ px[l];
        }
        return res;
    }
}