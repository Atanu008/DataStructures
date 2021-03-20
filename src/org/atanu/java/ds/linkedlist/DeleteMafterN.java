package org.atanu.java.ds.linkedlist;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class DeleteMafterN {

    public static void deleteMafterN(Node head, int m, int n) {

        Node current = head;

        while (current != null) {
            Node temp = null;
            for (int i = 1; i < n && current != null; i++) {
                current = current.next;
            }
            if (current == null) {
                return;
            }

            temp = current.next;
            for (int i = 1; i <= m && temp != null; i++) {
                temp = temp.next;
            }

            current.next = temp;// Jump to next start of N node to avoid Null Pointer
            current = temp;

        }

    }

    public static void main(String[] args) {

        LinkedList linkedListA = new LinkedList();

        linkedListA.push(1);
        linkedListA.append(9);
        linkedListA.append(7);

        linkedListA.push(2);
        linkedListA.append(3);
        linkedListA.append(4);
        linkedListA.append(5);
        linkedListA.append(8);


        LinkedList.printList(linkedListA.head);
        System.out.println();
        deleteMafterN(linkedListA.head, 2, 3);

        LinkedList.printList(linkedListA.head);

    }

}
