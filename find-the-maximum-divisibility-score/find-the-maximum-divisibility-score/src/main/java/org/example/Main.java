package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public int maxDivScore(int[] nums, int[] divisors) {
        int maxScore = 0;
        int bestDivisor = Integer.MAX_VALUE;

        for (int divisor : divisors) {
            int score = 0;

            // Calculate divisibility score for the current divisor
            for (int num : nums) {
                if (num % divisor == 0) {
                    score++;
                }
            }

            // Update the best divisor based on the score
            if (score > maxScore || (score == maxScore && divisor < bestDivisor)) {
                maxScore = score;
                bestDivisor = divisor;
            }
        }

        return bestDivisor;
    }
}