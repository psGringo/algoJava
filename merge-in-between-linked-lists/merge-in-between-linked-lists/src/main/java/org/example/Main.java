package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode nodeBeforeA = getNodeByIndex(list1, a - 1);
        ListNode nodeAfterB = getNodeByIndex(list1, b + 1);
        nodeBeforeA.next = list2;
        var lastNodeOfList2 = getLastNode(list2);
        lastNodeOfList2.next = nodeAfterB;
        return list1;
    }

    private static ListNode getLastNode(ListNode list2) {
        ListNode curr = list2;
        while (curr != null) {
            if (curr.next == null) {
                return curr;
            }
            curr = curr.next;
        }

        return null;
    }

    private static ListNode getNodeByIndex(ListNode head, int index) {
        var curr = head;
        int i = 0;
        while (curr != null) {
            if (i == index) {
                return curr;
            }
            i++;
            curr = curr.next;
        }
        return null;
    }

}