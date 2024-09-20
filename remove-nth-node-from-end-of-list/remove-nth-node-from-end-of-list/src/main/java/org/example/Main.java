package org.example;


public class Main {
    public static void main(String[] args) {

    }

    /**
     *
     * You have 2 pointers: fast, slow. Find length of the linked list in half pass and in half pass find the target node depends on the position of target (length - n where n is NthFromEnd) and based on slow (in a left side from slow or in a right side from slow).
     *
     * We have 2 pointers: fast, slow. slow is doing slow.next (and count slowCounter++) when fast is doing fast.next.next (and count fastCounter += 2). At the end of the day, through len / 2 (where len is the length of the linked list) we will count len with fast pointer.
     *
     * Next we calculate the position of the node to remove like pos = len - n and, it's importent,
     * if pos > slowCounter then target is in between slow and fast (to find it target need half pass, because slow is in the center and fast in the end);
     * else (if pos <= slowCounter) then target is in between head and slow (you can find the target in half pass).
     *
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        int fastCount = 1;
        int slowCount = 0;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            fastCount += 2;
            slowCount++;
        }
        if (fast.next != null) {
            fastCount++;
        }
        int nodeIndex = fastCount - n;
        if (nodeIndex == 0) {
            return head.next;
        }
        ListNode prev;
        ListNode cur;
        int count = 0;
        if (slowCount < nodeIndex) {
            prev = slow;
            cur = slow.next;
            count = slowCount + 1;
        } else {
            count = 0;
            prev = null;
            cur = head;
        }

        while (count < nodeIndex) {
            prev = cur;
            cur = cur.next;
            count++;
        }

        prev.next = cur.next;

        return head;
    }

}