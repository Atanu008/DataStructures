package org.bgd.java.ds.linkedlists;

/**
 * <a href="https://leetcode.com/problems/sort-list/">...</a>
 * 148. Sort List
 * Given the head of a linked list, return the list after sorting it in ascending order.
 */
public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode m = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(m);
        return merge(left, right);
    }

    ListNode getMid(ListNode head) {
        ListNode midPrev = null;

        while (head != null && head.next != null) {
            midPrev = midPrev == null ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode m = midPrev.next;
        midPrev.next = null;
        return m;
    }

    ListNode merge(ListNode list1, ListNode list2) {
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
