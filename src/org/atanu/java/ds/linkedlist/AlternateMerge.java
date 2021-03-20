package org.atanu.java.ds.linkedlist;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class AlternateMerge {


    public static void alterMergeSol1(Node a, Node b) {

        Node dummy = new LinkedList().new Node();

        Node tail = dummy;

        while (true) {
            if (a == null) {
                tail.next = b;
                break;
            }
            if (b == null) {
                tail.next = a;
                break;
            } else {
                tail.next = a;
                tail = tail.next;
                a = a.next;

                tail.next = b;
                tail = tail.next;
                b = b.next;
            }
        }

        a = dummy.next;

        System.out.println("\nAlternate Mergred List");
        LinkedList.printList(a);
        System.out.println("\nRemaining Second List");
        LinkedList.printList(b);// b will be pointing to the ahead of the remaining list

    }

    public static void alterMergeSol2(Node a, Node b) {
        Node root = a;// it will be needed to get the head of the new list
        while (a != null && b != null) {
            Node a1 = a.next;
            Node b1 = b.next;
            a.next = b;
            //b.next = a1;(Have to check)
            a = a1;
            b = b1;
        }
        System.out.println("\nAlternate Mergred List");
        LinkedList.printList(root);
        System.out.println("\nRemaining Second List");
        LinkedList.printList(b);// b will be pointing to the ahead of the remaining list

    }

    public static void main(String[] args) {

        LinkedList linkedListA = new LinkedList();

        linkedListA.push(1);
        linkedListA.append(2);
        linkedListA.append(3);

        System.out.println("First List");
        LinkedList.printList(linkedListA.head);

        LinkedList linkedListB = new LinkedList();

        linkedListB.push(4);
        linkedListB.append(5);
        linkedListB.append(6);
        linkedListB.append(7);
        linkedListB.append(8);


        System.out.println("\nSecond List");
        LinkedList.printList(linkedListB.head);

        alterMergeSol1(linkedListA.head, linkedListB.head);
    }

}
