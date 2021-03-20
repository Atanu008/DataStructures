package org.atanu.java.ds.linkedlist;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class DeleteLastOccurence {

    public static void deleteLastOccurence(Node head, int key) {

        Node current = head;
        Node occurPointer = null;

        while (current != null) {
            if (current.data == key)
                occurPointer = current;
            current = current.next;
        }

        //If the last occurence is teh last node
        if (occurPointer != null && occurPointer.next == null) {
            current = head;
            while (current != null && current.next != occurPointer) {
                current = current.next;
            }
            current.next = null;
        }

        if (occurPointer != null && occurPointer.next != null) {
            occurPointer.data = occurPointer.next.data;
            occurPointer.next = occurPointer.next.next;
        }

    }

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.push(1);
        linkedList.append(9);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);
        linkedList.append(7);
        linkedList.append(5);
        linkedList.append(8);
        linkedList.append(9);

        linkedList.printList(linkedList.head);

        deleteLastOccurence(linkedList.head, 5);
        System.out.println();

        linkedList.printList(linkedList.head);
    }

}
