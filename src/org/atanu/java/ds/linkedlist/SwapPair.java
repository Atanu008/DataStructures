package org.atanu.java.ds.linkedlist;

import org.atanu.java.ds.linkedlist.LinkedList.Node;


/**
 * @author Atanu
 * Pairwise swap elements in Linked List
 */
public class SwapPair {

    public static Node swapPair(Node head) {

        Node dummy = new LinkedList().new Node();
        dummy.next = head;
        Node prev = dummy;

        while (prev != null && prev.next != null && prev.next.next != null) {
            prev.next = swap(prev.next, prev.next.next);
            prev = prev.next.next;
        }

        return dummy.next;
    }


    private static Node swap(Node next1, Node next2) {

        next1.next = next2.next;
        next2.next = next1;
        return next2;
    }

    public static void main(String[] args) {


        LinkedList linkedList = new LinkedList();

        linkedList.push(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);
        linkedList.append(7);
        linkedList.append(8);
        linkedList.append(9);

        linkedList.printList(linkedList.head);

        Node changedHead = swapPair(linkedList.head);

        System.out.println();
        linkedList.printList(changedHead);
    }

}
