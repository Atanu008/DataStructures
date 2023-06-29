package org.atanu.java.ds.linkedlist;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
// Leetcode 83

public class RemoveDuplicatesFromSortedList {


    // Because the input list is sorted,
    // we can determine if a node is a duplicate by comparing its value to the node after it in the list.
    // If it is a duplicate, we change the next pointer of the current node so that it skips the next node
    // and points directly to the one after the next node.
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }


    public static void removeDuplicateMethod(Node head) {

        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }


    public static void main(String[] args) {


        LinkedList linkedList = new LinkedList();

        linkedList.push(1);
        linkedList.append(2);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(4);

        linkedList.printList(linkedList.head);
        removeDuplicateMethod(linkedList.head);
        System.out.println();
        linkedList.printList(linkedList.head);

    }

}
