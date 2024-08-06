package org.bgd.java.ds.linkedlists;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * <a href="https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list/description/?envType=weekly-question&envId=2024-07-08">...</a>
 *
 *
 * Given the head of a linked list, find all the values that appear more than once in the list and delete the nodes that have any of those values.
 *
 * Input: head = [1,2,3,2]
 * Output: [1,3]
 * Explanation: 2 appears twice in the linked list, so all 2's should be deleted. After deleting all 2's, we are left with [1,3].
 *
 *
 * Input: head = [2,1,1,2]
 * Output: []
 * Explanation: 2 and 1 both appear twice. All the elements should be deleted.
 */
public class RemoveDuplicateFromanUnsortedLinkedList {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();

        ListNode h = head;

        while (h != null) {
            map.put(h.val, map.getOrDefault(h.val, 0) + 1);
            h = h.next;
        }

        ListNode dummy = new ListNode(-1);

        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = dummy.next;
        while (curr != null) {
            if (map.get(curr.val) > 1) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
