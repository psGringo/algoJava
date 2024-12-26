package org.example;


import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/find-the-number-of-winning-players/description/
 */
public class Main {
    public static void main(String[] args) {
//        int[][] pick = new int[][]{{0, 0}, {1, 0}, {1, 0}, {2, 1}, {2, 1}, {2, 0}};
        int[][] pick = new int[][]{{0, 8}, {0, 3}};
        winningPlayerCount(4, pick);
    }

    public static int winningPlayerCount(int n, int[][] pick) {
        HashMap<Integer, HashMap<Integer, Integer>> players = new HashMap<>();

        for (int i = 0; i < pick.length; i++) {
            int color = pick[i][1];
            int player = pick[i][0];
            if (players.containsKey(player)) {
                HashMap<Integer, Integer> hashMapPlayer = players.get(player);
                hashMapPlayer.put(color, hashMapPlayer.getOrDefault(color, 0) + 1);
            } else {
                HashMap<Integer, Integer> hashMapPlayer = new HashMap<>();
                hashMapPlayer.put(color, 1);
                players.put(player, hashMapPlayer);
            }
        }


        HashSet<Integer> resultPlayers = new HashSet<>();
        var iterator = players.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            int player = entry.getKey();
            var countsIterator = entry.getValue().values().iterator();
            while (countsIterator.hasNext()) {
                int count = countsIterator.next();
                if (count > player) {
                    resultPlayers.add(player);
                }
            }

        }

        return resultPlayers.size();
    }

}