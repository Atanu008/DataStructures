package org.bgd.java.ds.linkedlists;

/**
 * <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/description/">...</a>
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 */
public class ReverseKGroups {
    /**
     * Recursive solution
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int c = 0;
        while (c != k && curr != null) {
            c++;
            curr = curr.next;
        }
        if (c == k) {
            ListNode rev = reverse(head, k);
            head.next = reverseKGroup(curr, k);
            return rev;
        }
        return head;
    }

    /**
     * Iterative solution
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroupIterative(ListNode head, int k) {
        ListNode curr = head;
        ListNode newHead = null;
        ListNode kTail = null;
        while (curr != null) {
            int c = 0;
            while (c != k && curr != null) {
                c++;
                curr = curr.next;
            }
            if (c == k) {
                ListNode revHead = reverse(head, k);
                if (newHead == null) {
                    newHead = revHead;
                }
                if (kTail != null) {
                    kTail.next = revHead;
                }
                kTail = head;
                head = curr;
            }
        }
        if (kTail != null) {
            kTail.next = head;
        }
        return newHead;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode curr = head, prev = null;
        while (k > 0) {
            ListNode t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;
            k--;
        }
        return prev;
    }
}
