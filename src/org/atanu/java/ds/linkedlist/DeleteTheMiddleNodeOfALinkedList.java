package org.atanu.java.ds.linkedlist;

//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
//LeetCode 2095
public class DeleteTheMiddleNodeOfALinkedList {

    public ListNode deleteMiddle(ListNode head) {
        // Base Condition
        if(head == null || head.next == null) return null;

        ListNode slowPointer = head;
        ListNode fastPointer = head;
        ListNode prev = null;
        while(fastPointer != null && fastPointer.next != null){
            prev = slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        if(prev != null){
            prev.next = slowPointer.next;
        }

        return head;

    }
}
