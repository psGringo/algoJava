package org.example;


import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        timeRequiredToBuy(new int[]{2, 3, 2}, 2);
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        Queue<TicketBuyer> queue = new LinkedList<>();

        for (int i = 0; i < tickets.length; i++) {
            queue.add(new TicketBuyer(i, tickets[i]));
        }

        int i = 0;
        int time = 0;
        while (true) {
            TicketBuyer buyer = queue.poll();
            buyer.setValue(buyer.getValue() - 1);
            ++time;
            if (buyer.getIndex() == k && buyer.getValue() == 0) {
                break;
            }
            if (buyer.getValue() > 0) {
                queue.add(buyer);
            }
        }

        return time;
    }

    static class TicketBuyer {
        private int index;
        private int value;

        public TicketBuyer(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

}

