package org.bgd.java.ds.linkedlists;

/**
 * <a href="https://leetcode.com/problems/reorder-list/">...</a>
 * You are given the head of a singly linked-list. The list can be represented as:
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;

        // visit the middle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse second half
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode first = head;
        ListNode second = prev;

        while (second.next != null) {
            ListNode t = first.next;
            first.next = second;
            first = t;

            t = second.next;
            second.next = first;
            second = t;
        }
    }
}
