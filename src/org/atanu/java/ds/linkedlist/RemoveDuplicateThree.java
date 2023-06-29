package org.atanu.java.ds.linkedlist;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
// Leetcode 82

public class RemoveDuplicateThree {

    public ListNode deleteDuplicates(ListNode head) {
        // sentinel
        ListNode dummy = new ListNode();
        // predecessor = the last node
        // before the sublist of duplicates
        ListNode prev = dummy;
        dummy.next = head;
        ListNode current = head;

        while (current != null) {
            // if it's a beginning of duplicates sublist
            // skip all duplicates
            if (current.next != null && current.val == current.next.val) {
                // move till the end of duplicates sublist
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                // skip all duplicates
                prev.next = current.next; // current points to last duplicate. so current.next will skip all duplicates
                // otherwise, move predecessor
            } else {
                prev = prev.next; // Or prev = current;
            }

            // move forward
            current = current.next;
        }
        return dummy.next;
    }

    private static Node removeDuplicateMethod1(Node head) {

        Node dummy = new LinkedList().new Node();
        dummy.next = head;
        Node prev = dummy;
        Node current = head;

        while (current != null) {
            // if it's a beginning of duplicates sublist
            // skip all duplicates
            if (current.next != null && current.data == current.next.data) {
                // move till the end of duplicates sublist
                while (current.next != null && current.data == current.next.data) {
                    current = current.next;
                }
                // skip all duplicates
                prev.next = current.next;
                // otherwise, move predecessor
            } else {
                prev = prev.next;
            }

            // move forward
            current = current.next;
        }
        return dummy.next;

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
        linkedList.append(8);
        linkedList.printList(linkedList.head);

        Node changedHead = removeDuplicateMethod1(linkedList.head);
        System.out.println();
        linkedList.printList(changedHead);

    }


}
