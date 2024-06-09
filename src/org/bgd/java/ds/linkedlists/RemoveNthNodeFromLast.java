package org.bgd.java.ds.linkedlists;

/**
 * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">...</a>
 * 19. Remove Nth Node From End of List
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class RemoveNthNodeFromLast {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode start = newHead;
        ListNode follow = newHead;
        for (int i = 0; i <= n; i++) {
            start = start.next;
        }
        while (start != null) {
            start = start.next;
            follow = follow.next;
        }
        follow.next = follow.next.next;
        return newHead.next;
    }
}
