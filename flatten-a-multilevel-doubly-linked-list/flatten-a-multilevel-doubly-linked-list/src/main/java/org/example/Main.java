package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Node head = new Node();
        head.val = list.get(0);
        Node curr = head;
        for (int i = 1; i < list.size(); i++) {
            curr.next = new Node();
            curr.next.val = list.get(i);
            curr = curr.next;
        }

        flatten(head);
    }

    public static Node flatten(Node head) {
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {

                Node next = curr.next;
                if (next != null) {
                    next.prev = null;
                }

                Node child = curr.child;
                curr.child = null;

                Node flatHead = flatten(child);

                // connecting left side
                curr.next = flatHead;
                flatHead.prev = curr;

                //connecting right side
                Node flatTail = flatHead;
                while (flatTail.next != null) {
                    flatTail = flatTail.next;
                }
                flatTail.next = next;
                if (next != null) {
                    next.prev = flatTail;
                }

                curr = next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

}