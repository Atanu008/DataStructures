package org.atanu.java.ds.linkedlist;

//https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
//LeetCode 2130
public class MaximumTwinSumOfALinkedList {

    //reverse the second Half
    //Take two pointer , one will point to head of first half and another will point to head of second half
    //calculate sum and move both pointers, also calculate maxTwinSum as well
    public int pairSum(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middle = slow;
        ListNode startOfSecondReversedHalf = reverse(middle);
        ListNode startOfFirstdHalf = head;

        int maxTwinSum = Integer.MIN_VALUE;
        while(startOfFirstdHalf != null && startOfSecondReversedHalf != null){
            maxTwinSum = Math.max(maxTwinSum, startOfFirstdHalf.val + startOfSecondReversedHalf.val);
            startOfFirstdHalf = startOfFirstdHalf.next;
            startOfSecondReversedHalf = startOfSecondReversedHalf.next;
        }

        return maxTwinSum;
    }

    private ListNode reverse(ListNode head){

        ListNode previous = null;
        ListNode next = null;
        ListNode current = head;

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
