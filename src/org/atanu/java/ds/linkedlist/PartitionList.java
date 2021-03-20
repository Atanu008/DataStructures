package org.atanu.java.ds.linkedlist;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class PartitionList {


    public static Node partitionList(Node head, int x) {

        Node curr = head;

        Node dummy1 = new LinkedList().new Node();
        Node p = dummy1;

        Node dummy2 = new LinkedList().new Node();
        Node q = dummy2;

        while (curr != null) {
            if (curr.data < x) {
                p.next = curr;
                p = p.next;
            } else {
                q.next = curr;
                q = q.next;
            }

            curr = curr.next;
        }

        p.next = dummy2.next; // Join Two link
        q.next = null; // Make the last node to null

        return dummy1.next;

    }

    public static void main(String[] args) {


        LinkedList linkedListA = new LinkedList();

        linkedListA.push(1);
        linkedListA.append(4);
        linkedListA.append(3);
        linkedListA.append(2);
        linkedListA.append(5);
        linkedListA.append(2);
        linkedListA.append(3);
        linkedListA.append(9);

        Node changedNode = partitionList(linkedListA.head, 3);

        LinkedList.printList(changedNode);

    }

}
