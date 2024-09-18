package org.example;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists
 */
public class Main {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoListsNewList(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        }

        List<Integer> values = new ArrayList<>();
        while (list1 != null) {
            values.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            values.add(list2.val);
            list2 = list2.next;
        }

        System.out.println(values.size());

        Collections.sort(values);

        ListNode head = new ListNode(values.get(0));
        ListNode current = head;
        for (int i = 1; i < values.size(); i++) {
            current.next = new ListNode(values.get(i));
            current = current.next;
        }
        return head;
    }

}