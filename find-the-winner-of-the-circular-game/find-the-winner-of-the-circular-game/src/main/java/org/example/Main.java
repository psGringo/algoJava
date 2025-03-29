package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        findTheWinner(6, 5);
    }

    public static int findTheWinner(int n, int k) {
        List<Integer> friends = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            friends.add(i);
        }

        int currIndex = 0;

        while (friends.size() > 0) {
            currIndex = (currIndex + k - 1) % friends.size();
            friends.remove(currIndex);
        }
        return friends.get(0);
    }


    /**
     * https://leetcode.com/problems/find-the-winner-of-the-circular-game/
     *
     * @param n
     * @param k
     * @return
     */
    public static int findTheWinner2(int n, int k) {
        List<Integer> friends = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            friends.add(i);
        }

        int currIndex = 0;

        while (friends.size() > 1) {
            int currCountFriends = 0;
            while (currCountFriends < k - 1) {
                currIndex++;
                if (currIndex >= friends.size()) {
                    currIndex = 0;
                }
                currCountFriends++;
            }
            friends.remove(currIndex);
            if (currIndex == friends.size()) {
                currIndex = 0;
            }
        }
        return friends.get(0);
    }
}