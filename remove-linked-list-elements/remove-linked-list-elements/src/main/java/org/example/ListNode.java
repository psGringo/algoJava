package org.example;

  public class ListNode {
      int val;
      ListNode next;
      int index;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, int index) { this.val = val; this.index = index; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
