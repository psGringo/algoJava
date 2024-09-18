package org.example;


/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode resultHead = new ListNode(head.val);
        ListNode currResult = resultHead;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val != currResult.val) {
                currResult.next = new ListNode(curr.val);
                currResult = currResult.next;
            }
            curr = curr.next;
        }
        return resultHead;
    }

}