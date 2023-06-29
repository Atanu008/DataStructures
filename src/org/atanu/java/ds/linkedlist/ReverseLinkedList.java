package org.atanu.java.ds.linkedlist;

//https://leetcode.com/problems/reverse-linked-list/
//LeetCode 206
// Short Video : https://www.youtube.com/watch?v=HVpkWdVVkwc

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode current = head; // current node that we will be processing
        ListNode previous = null; // previous node that we have processed
        ListNode next = null; // will be used to temporarily store the next node

        while(current != null) {
            next = current.next; // temporarily store the next node
            current.next = previous; // reverse the current node
            previous = current; // before we move to the next node, point previous to the current node
            current = next; // move on the next node
        }
        // after the loop current will be pointing to 'null' and 'previous' will be the new head
        return previous;
    }
}
