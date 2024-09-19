package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/linked-list-cycle/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (nodes.contains(head)) {
                return true;
            }
            nodes.add(head);
            head = head.next;
        }
         return false;
    }

}