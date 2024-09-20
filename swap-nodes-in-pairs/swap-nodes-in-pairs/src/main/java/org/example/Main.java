package org.example;


/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 */
public class Main {
    public static void main(String[] args) {

        int[] vals = new int[]{1, 2, 3, 4};
        ListNode head = new ListNode(vals[0], 0);
        ListNode curr = head;
        for (int i = 1; i < vals.length; i++) {
            curr.next = new ListNode(vals[i], i);
            curr = curr.next;
        }

        swapPairs(head);
    }

    /**
     * here we need to keep in mind 4 nodes
     * prev which is fake on start
     * curr which is head
     * next which is next to current
     * next.next which is after next
     *
     * change node  by pairs like below
     *
     * fakeNode -> 1 -> 2 -> 3 -> 4
     *
     * fakeNode -> 2 -> 1 -> 3 -> 4 // changed 1 and 2
     *
     * fakeNode -> 2 -> 1 -> 4 -> 3 // changed 3 and 4
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode res = head.next;

        ListNode fakeNode = new ListNode(0, head.next);
        ListNode prev = fakeNode;
        ListNode curr = head;

        while (true) {
            if (curr == null || curr.next == null) {
                break;
            }
            ListNode next = curr.next;
            ListNode next2 = next.next;

            prev.next = next;
            next.next = curr;
            curr.next = next2;

            prev = curr;
            curr = next2;
        }

        return res;
    }
}