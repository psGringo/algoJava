package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-linked-list/description/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(5/2);
        isPalindrome(new ListNode());
    }

    public static boolean isPalindrome(ListNode head) {
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