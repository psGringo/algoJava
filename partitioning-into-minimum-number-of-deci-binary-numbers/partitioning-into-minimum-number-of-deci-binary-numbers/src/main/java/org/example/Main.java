package org.example;


public class Main {
    public static void main(String[] args) {

    }

    /**
     * this is more math problem, than programming
     *  "Thus the answer is equal to the max digit"
     * @param n
     * @return
     */
    public int minPartitions(String n) {
        int max = Integer.MIN_VALUE;
        for (char c : n.toCharArray()) {
            max = Math.max(max, c - '0');
            if (max == '9') {
                return max;
            }
        }
        return max;
    }

}