package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/
 */
public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode curr = head;

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(1);
        for (int i = 0; i < list.size(); i++) {
            curr.next = new ListNode(list.get(i));
            curr = curr.next;
        }
        int res = pairSum(head);
    }

    private static ListNode curr;
    private static Integer result = 0;

    public static int pairSum(ListNode head) {
        curr = head;
        doPairSum(head);
        return result;
    }


    public static void doPairSum(ListNode node) {
        if (node == null) {
            return;
        }
        doPairSum(node.next);
        result = Math.max(result, node.val + curr.val);
        curr = curr.next;
    }
}