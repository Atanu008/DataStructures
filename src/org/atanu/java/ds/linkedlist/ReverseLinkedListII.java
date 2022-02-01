package org.atanu.java.ds.linkedlist;

//https://leetcode.com/problems/reverse-linked-list-ii/
//LeetCode 92
//https://www.educative.io/courses/grokking-the-coding-interview/qVANqMonoB2
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode current = head;
        ListNode previous = null;

        // after skipping 'left-1' nodes, current will point to 'p'th node
        for(int i = 0; i < left -1 && current != null; i++) {
            previous = current;
            current = current.next;
        }

        // we are interested in three parts of the LinkedList, part before index 'left', part between 'left' and
        // 'right', and the part after index 'right'
        ListNode lastNodeOfFirstPart = previous; // points to the node at index 'p-1'
        ListNode lastNodeOfSubList = current;// after reversing the LinkedList 'current' will become the last node of the sub-list
        // will be used to temporarily store the next node
        previous = null;
        ListNode next = null; // reverse nodes between 'left' and 'right'
        for(int i = 0; i < right -left +1 && current != null; i++){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        // connect with the first part
        if(lastNodeOfFirstPart != null){
            lastNodeOfFirstPart.next = previous; // 'previous' is now the first node of the sub-list
        }
        else {
            head = previous; // this means p == 1 i.e., we are changing the first node (head) of the LinkedList
        }

        // connect with the last part
        lastNodeOfSubList.next = current;

        return head;
    }
}
