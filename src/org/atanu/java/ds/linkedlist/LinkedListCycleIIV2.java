package org.atanu.java.ds.linkedlist;

//https://leetcode.com/problems/linked-list-cycle-ii/
//LeetCode 142
//just simplified version
public class LinkedListCycleIIV2 {

    public ListNode detectCycle(ListNode head) {
        int cycleLength = 0;
        // find the LinkedList cycle
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) { // found the cycle
                cycleLength = calculateCycleLength(slow);
                return findStart(head, cycleLength);
            }
        }
        return null;

    }

    private int calculateCycleLength(ListNode slow) {
        ListNode current = slow;
        int cycleLength = 0;
        do {
            current = current.next;
            cycleLength++;
        } while (current != slow);

        return cycleLength;
    }

    private ListNode findStart(ListNode head, int cycleLength) {
        System.out.println("LK");
        ListNode pointer1 = head, pointer2 = head;
        // move pointer2 ahead 'cycleLength' nodes
        while (cycleLength > 0) {
            pointer2 = pointer2.next;
            cycleLength--;
        }

        // increment both pointers until they meet at the start of the cycle
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }
}
