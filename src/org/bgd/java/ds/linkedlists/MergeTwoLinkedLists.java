package org.bgd.java.ds.linkedlists;

/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/description/">...</a>
 * 21. Merge Two Sorted Lists
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */
public class MergeTwoLinkedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                head = head.next;
                list1 = list1.next;
            } else {
                head.next = list2;
                head = head.next;
                list2 = list2.next;
            }
        }
        head.next = (list1 == null) ? list2 : list1;
        return result.next;
    }
}
}
