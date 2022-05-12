package org.atanu.java.ds.linkedlist;

//https://leetcode.com/problems/odd-even-linked-list/
//LeetCode 328
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        // `even != null` rules out the list of only 1 node
        // `even.next != null` rules out the list of only 2 nodes
        while(even != null && even.next != null){
            // Put odd to the odd list
            odd.next = odd.next.next;
            // Put even to the even list
            even.next = even.next.next;
            // Move the pointer to the next odd/even
            odd = odd.next;
            even = even.next;
        }

        //connect tail of odd to head of even
        odd.next = evenHead;
        return head;
    }
}
