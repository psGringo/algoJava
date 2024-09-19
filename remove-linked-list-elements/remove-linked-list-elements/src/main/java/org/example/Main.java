package org.example;


/**
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 */
public class Main {
    public static void main(String[] args) {

        int[] vals = new int[]{1, 2, 2, 1};
        ListNode head = new ListNode(vals[0]);
        ListNode curr = head;
        for (int i = 1; i < vals.length; i++) {
            curr.next = new ListNode(vals[i], i);
            curr = curr.next;
        }
        removeElements(head, 2);
    }

    public static ListNode removeElements(ListNode head, int val) {

        ListNode fakeNode = new ListNode(Integer.MIN_VALUE, -1);
        fakeNode.next = head;

        ListNode prev = null;
        ListNode curr = fakeNode;

        while (curr != null) {

            if (curr.val == val) {
                removeNode(prev, curr.next);
                if (curr == head) {
                    head = curr.next;
                }
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
    }

    private static void removeNode(ListNode prev, ListNode next) {
        if (prev != null) {
            prev.next = next;
        }
    }

}