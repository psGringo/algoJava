package org.example;


/**
 * https://leetcode.com/problems/middle-of-the-linked-list
 */
public class Main {
    public static void main(String[] args) {

    }

    public static ListNode middleNode(ListNode head) {
        int count = getCount(head);
        int middle = getMiddle(count);

        count = 1;
        ListNode current = head;
        while (current != null) {
            if (count == middle) {
                return current;
            }
            count++;
            current = current.next;
        }

        return null;
    }

    private static int getCount(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    private static int getMiddle(int count) {
        int middle = 0;
        if (count % 2 == 0) {
            middle = count / 2 + 1;
        } else {
            middle = (int) Math.ceil(count / 2.0);
        }
        return middle;
    }

}