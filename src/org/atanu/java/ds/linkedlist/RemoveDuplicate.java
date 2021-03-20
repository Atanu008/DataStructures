package org.atanu.java.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class RemoveDuplicate {

    public static void removeDuplicateMethod1(Node head) {

        Node current = head;
        Node prev = null;
        Set<Integer> set = new HashSet();

        while (current != null) {
            if (set.contains(current.data)) {
                System.out.println(current.data);
                prev.next = current.next;
            } else {
                set.add(current.data);
                prev = current;
            }

            current = current.next;
        }

    }

    public static void removeDuplicateMethod2(Node head) {

        Node outerNode = head;

        while (outerNode != null && outerNode.next != null) {
            Node innerNode = outerNode;

            while (innerNode != null && innerNode.next != null) {

                if (outerNode.data == innerNode.next.data) {
                    innerNode.next = innerNode.next.next;
                } else {
                    innerNode = innerNode.next;
                }
            }

            outerNode = outerNode.next;
        }
    }

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.push(1);
        linkedList.append(2);
        linkedList.append(2);
        linkedList.append(4);
        linkedList.append(3);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(4);

        linkedList.printList(linkedList.head);

        removeDuplicateMethod2(linkedList.head);
        System.out.println();
        linkedList.printList(linkedList.head);

    }

}
