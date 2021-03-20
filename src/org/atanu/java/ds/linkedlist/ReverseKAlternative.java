package org.atanu.java.ds.linkedlist;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class ReverseKAlternative {

    public static Node reverseKAlternative(Node head, int k) {

        Node current = head;
        Node prev = null;
        int i = 0;

        while (current != null && i < k) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }

        if (head != null) {
            head.next = current; // Lining the next K item with the reversed one;
        }

        i = 1;
        while (current != null && i < k) {
            current = current.next;
            i++;
        }

        if (current != null) {
            current.next = reverseKAlternative(current.next, k);
        }

        return prev;
    }

    public static void main(String[] args) {

        LinkedList linkedListA = new LinkedList();

        linkedListA.push(1);
        linkedListA.append(9);
        linkedListA.append(7);

        linkedListA.append(8);
        linkedListA.append(6);
        linkedListA.append(4);

        linkedListA.append(9);
        linkedListA.append(6);
        linkedListA.append(2);

        LinkedList.printList(linkedListA.head);
        System.out.println();

        Node chNode = reverseKAlternative(linkedListA.head, 3);

        LinkedList.printList(chNode);
    }

}
