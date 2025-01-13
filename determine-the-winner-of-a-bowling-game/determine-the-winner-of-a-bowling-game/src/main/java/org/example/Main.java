package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public int isWinner(int[] player1, int[] player2) {
        int score1 = calculateScore(player1);
        int score2 = calculateScore(player2);

        if (score1 > score2) {
            return 1;
        } else if (score2 > score1) {
            return 2;
        } else {
            return 0;
        }
    }

    private int calculateScore(int[] scores) {
        int totalScore = 0;
        int doubleRounds = 0; // Tracks how many rounds should be doubled

        for (int i = 0; i < scores.length; i++) {
            if (doubleRounds > 0) {
                totalScore += scores[i] * 2;
                doubleRounds--;
            } else {
                totalScore += scores[i];
            }

            // Update doubleRounds if the current score is 10 or greater
            if (scores[i] >= 10) {
                doubleRounds = 2;
            }
        }

        return totalScore;
    }
}