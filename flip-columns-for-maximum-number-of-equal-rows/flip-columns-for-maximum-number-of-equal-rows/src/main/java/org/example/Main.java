package org.example;


import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

    }

    /**
     *
     *      * go for each row
     *      * normalize to 0
     *      * keep string as the key
     *      * put into HashMap
     *      * get max frequency
     *
     * Returns the maximum number of rows that can be made identical
     * by flipping any set of columns.
     *
     * <p>
     * A column flip toggles the value (0 ↔ 1) in that column for all rows.
     * Two rows can become equal after the same set of column flips if and only if
     * they are either identical or exact complements of each other.
     * </p>
     *
     * <p>
     * To group such rows, each row is converted into a canonical (normalized) form:
     * every element is XOR-ed with the first element of the row.
     * This guarantees that:
     * <ul>
     *   <li>Rows starting with {@code 0} remain unchanged</li>
     *   <li>Rows starting with {@code 1} are fully inverted</li>
     * </ul>
     * As a result, a row and its complement produce the same normalized pattern.
     * </p>
     *
     * <p>
     * The normalized row is encoded as a {@link String} key and counted using a
     * {@link HashMap}. The maximum frequency among all keys represents the largest
     * group of rows that can be made equal using the same column flips.
     * </p>
     *
     * <p>
     * Time complexity: O(n × m), where n is the number of rows and m is the number of columns.<br>
     * Space complexity: O(n × m) in the worst case due to stored keys.
     * </p>
     *
     * @param matrix a binary matrix where each element is either 0 or 1
     * @return the maximum number of rows that can be made equal after column flips
     */
    public static int maxEqualRowsAfterFlips(int[][] matrix) {

        HashMap<String, Integer> map = new HashMap<>();
        int maxFrequency = 0;

        for (int i = 0; i < matrix.length; i++) {
            var row = matrix[i];

            StringBuilder sb = new StringBuilder(row.length);
            for (int j = 0; j < row.length; j++) {
                int bitwise = row[j] ^ row[0];
                sb.append(bitwise);
            }
            String key = sb.toString();

            Integer currCount = map.getOrDefault(key, 0);

            maxFrequency = Math.max(maxFrequency, currCount + 1);

            map.put(key, currCount + 1);
        }

        return maxFrequency;
    }

}