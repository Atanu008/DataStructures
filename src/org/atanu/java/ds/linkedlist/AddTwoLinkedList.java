package org.atanu.java.ds.linkedlist;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class AddTwoLinkedList {

    public static Node addTwoLinkedListMethod1(Node a, Node b) {
        Node dummy = new LinkedList().new Node();
        Node pre = dummy;
        int sum = 0;
        while (a != null || b != null) {
            if (a != null) {
                sum += a.data;
                a = a.next;
            }

            if (b != null) {
                sum += b.data;
                b = b.next;
            }

            pre.next = new LinkedList().new Node(sum % 10);
            pre = pre.next;
            sum = sum / 10;
        }
        if (1 == sum)
            pre.next = new LinkedList().new Node(1);

        return dummy.next;
    }

    public static Node addTwoLinkedListMethod2(Node a, Node b, int carry) {
        //Initialize sum with the carry from previous call
        int sum = carry;
        Node result = null;

        if (a != null) {
            sum += a.data;
        }
        if (b != null) {
            sum += b.data;
        }

        if (a != null || b != null) {
            result = new LinkedList().new Node(sum % 10);

            result.next = addTwoLinkedListMethod2(a.next, b.next, sum / 10);
        }

        // If only left with carry
        else if (carry == 1) {
            result = new LinkedList().new Node(carry);
        }


        return result;
    }

    public static void main(String[] args) {

        LinkedList linkedListA = new LinkedList();

        linkedListA.push(8);
        linkedListA.append(4);
        linkedListA.append(3);

        LinkedList linkedListB = new LinkedList();

        linkedListB.push(5);
        linkedListB.append(6);
        linkedListB.append(2);

        LinkedList.printList(linkedListA.head);
        System.out.println("\n+");
        LinkedList.printList(linkedListB.head);
        System.out.println("\n---------");

        //Node addedList = addTwoLinkedListMethod1(linkedListA.head, linkedListB.head);

        Node addedList = addTwoLinkedListMethod2(linkedListA.head, linkedListB.head, 0);

        LinkedList.printList(addedList);
    }

}
