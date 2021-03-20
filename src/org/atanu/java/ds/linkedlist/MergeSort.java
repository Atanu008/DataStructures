package org.atanu.java.ds.linkedlist;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class MergeSort {

    public static Node mergeSort(Node head) {

        //Base Condition . Return when last Node or reached null
        if (head == null || head.next == null) {
            return head;
        }

        Node fastPointer = head;
        Node slowPointer = head;

        // To select the first element if there are Two element . Left is smaller than Right
        fastPointer = fastPointer.next;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        Node midElement = slowPointer;

        Node nextOfMidElement = midElement.next;

        slowPointer.next = null;

        //Recursively divide the halves
        Node leftHead = mergeSort(head);
        Node rightHead = mergeSort(nextOfMidElement);

        // Merge Two Sorted List and Return
        return merge(leftHead, rightHead);


    }

    public static Node merge(Node a, Node b) {


        if (a == null)
            return b;
        if (b == null)
            return a;

        Node result;

        if (a.data < b.data) {
            result = a;
            result.next = merge(a.next, b);
        } else {
            result = b;
            result.next = merge(a, b.next);
        }
        return result;
    }

    public static void main(String[] args) {

        LinkedList linkedListA = new LinkedList();

        linkedListA.push(6);
        linkedListA.append(4);
        linkedListA.append(5);
        linkedListA.append(3);
        linkedListA.append(1);
        linkedListA.append(2);


        LinkedList linkedListB = new LinkedList();

        linkedListB.push(4);
        linkedListB.append(5);
        linkedListB.append(6);

        //System.out.println(linkedListB.head);

        //Node changedHead = merge(linkedListA.head, linkedListB.head);

        //System.out.println(linkedListA.head.next.next.next.data);
        Node sortedHead = mergeSort(linkedListA.head);

        LinkedList.printList(sortedHead);

    }

}
