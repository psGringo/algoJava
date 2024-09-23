package org.example;


import java.util.*;

/**
 * https://leetcode.com/problems/next-greater-node-in-linked-list
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(7);
        list.add(5);
        list.add(1);
        list.add(9);
        list.add(2);
        list.add(5);
        list.add(1);

        ListNode head = new ListNode(list.get(0));
        ListNode curr = head;
        for (int i = 1; i < list.size(); i++) {
            curr.next = new ListNode(list.get(i));
            curr = curr.next;
        }

        nextLargerNodes(head);
    }

    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        head = reverseList(head);
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            while (!stack.isEmpty() && stack.peek() <= head.val) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(head.val);
                list.add(0);
            } else {
                list.add(stack.peek());
                stack.push(head.val);
            }
            head = head.next;
        }

        List<Integer> reversedList = list.subList(0, list.size());
        Collections.reverse(reversedList);
        Integer[] res = reversedList.toArray(new Integer[list.size()]);
        return Arrays.stream(res).mapToInt(Integer::intValue).toArray();
    }


    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }


}