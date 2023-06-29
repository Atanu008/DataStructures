package org.atanu.java.ds.linkedlist;

// https://leetcode.com/problems/remove-linked-list-elements/description/
// Leetcode 203

//Use a dummy node as head so the logic can be straightforward
//(avoids handling edge case of deleting the head of the list)
//Initialize prev to the dummy node, curr to head of list and next to node after it

//When you delete a node, move forward current and next pointers while keeping previous in place
//Remember that you have a dummy head node so when returning the new list head you give dummy.next

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        prev.next = head;
        ListNode curr = head;

        while(curr != null){
            if(curr.val == val){
                prev.next = curr.next; // Got the element. Remove it by pointing previous next to its next
            }
            else{
                prev = curr; // update previous to current .
            }
            curr = curr.next; // move current in each step.
        }
        return dummy.next;
    }
}
