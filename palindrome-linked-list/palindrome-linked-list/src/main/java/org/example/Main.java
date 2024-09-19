package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-linked-list/description/
 */
public class Main {

    private ListNode curr;

    public static void main(String[] args) {
        System.out.println(5/2);
        isPalindromeExtractToStrings(new ListNode());
    }

    public boolean isPalindromeRecursive(ListNode head) {
        curr = head;
        return isPalindromeDoRecursive(curr);
    }


    public boolean isPalindromeDoRecursive(ListNode head) {

        if (head == null) {
            return true;
        }
        // head is going until the end of the list
        var res = isPalindromeDoRecursive(head.next) && head.val == curr.val;

        // after floating up starting shifting from initial head to the next nodes and compare them
        curr = curr.next;
        return res;
    }


    public static boolean isPalindromeExtractToStrings(ListNode head) {
        if (head.next == null) {
            return true;
        }

        List<Integer> values =  new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        Integer[] array = values.toArray(new Integer[values.size()]);
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] != array[j]) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

}