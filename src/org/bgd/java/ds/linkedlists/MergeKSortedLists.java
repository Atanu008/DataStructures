package org.bgd.java.ds.linkedlists;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists/description/">...</a>
 * 23. Merge k Sorted Lists
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 */

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);
            }
        }

        ListNode result = new ListNode(0);
        ListNode head = result;

        while (!heap.isEmpty()) {
            ListNode top = heap.poll();
            head.next = top;
            head = head.next;
            if (top.next != null) {
                heap.offer(top.next);
            }
        }
        return result.next;
    }
}
