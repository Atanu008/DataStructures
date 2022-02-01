package org.atanu.java.ds.linkedlist;

//https://leetcode.com/problems/reverse-nodes-in-k-group/
//LeetCode 25
public class ReverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int count = 0;
        ListNode temp = head;
        // First, see if there are atleast k nodes
        // left in the linked list.
        while (temp != null && count != k) {
            temp = temp.next;
            count++;
        }
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        // If we have k nodes, then we reverse them
        if (count == k) {
            //Reverse K
            while (current != null && count > 0) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count--;
            }
            // Now recurse on the remaining linked list. Since
            // our recursion returns the head of the overall processed
            // list, we use that and the "original" head of the "k" nodes
            // to re-wire the connections.
            head.next = reverseKGroup(current, k);
            return prev;
        }

        return head;
    }
}
