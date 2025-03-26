package org.example;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

    }

    /**
     * here we use reverse simulation
     *
     * @param deck
     * @return
     */
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> deq = new LinkedList<>();

        for (int i = deck.length - 1; i >=0; i--) {
            if (!deq.isEmpty()) {
                deq.addFirst(deq.removeLast());
            }
            deq.addFirst(deck[i]);
        }

        int[] result = new int[deck.length];
        int index = 0;
        for (int num : deq) {
            result[index++] = num;
        }
        return result;
    }
}