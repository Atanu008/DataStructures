package org.atanu.java.ds.linkedlist;

//https://leetcode.com/problems/middle-of-the-linked-list/
//LeetCode 876
public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode fast_ptr = head;
        ListNode slow_ptr = head;

        while (fast_ptr != null && fast_ptr.next != null) {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }

        return slow_ptr;
    }
}
