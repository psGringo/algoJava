package org.example;


import java.util.ArrayList;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-node-in-linked-list
 */
public class Main {
    public static void main(String[] args) {
        nextLargerNodes(null);
    }

    public static int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(5);

        Stack<Integer> s = new Stack<>();
//        ListNode curr = head;
//        int count = 0;
//        while (curr != null) {
//            count++;
//            list.add(curr.val);
//            curr = curr.next;
//        }
        int ans[] = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
//            while (!s.isEmpty() && list.get(i) > s.peek()) {
//                s.pop();
//            }
//            if (s.isEmpty()) {
//                ans[i] = 0;
//            } else {
//                ans[i] = s.peek();
//            }
            s.push(list.get(i));
        }
        return ans;


//        Stack<Integer> s = new Stack<>();
//        ListNode q1 = head;
//        while (q1 != null) {
//            list.add(q1.val);
//            q1 = q1.next;
//        }
//        int result[] = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            while (!s.isEmpty() && list.get(i) > list.get(s.peek())) {
//                result[s.pop()] = list.get(i);
//            }
//            s.push(i);
//        }
//        return result;
    }

}