package org.example;


/**
 * https://leetcode.com/problems/odd-even-linked-list/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null || head.next.next == null) {
            return head;
        }
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHead = head.next;
        ListNode oddTail = null;
        while (oddNode.next != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            evenNode.next = evenNode.next.next;

            oddNode = oddNode.next;
            evenNode = evenNode.next;
            if (oddNode.next == null || evenNode.next == null) {
                oddTail = oddNode;
            }
        }

        oddTail.next = evenHead;

        return head;
    }
}