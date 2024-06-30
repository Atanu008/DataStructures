package org.bgd.java.ds.linkedlists;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/description/">...</a>
 * 206. Reverse Linked List
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

public class ReverseALinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
