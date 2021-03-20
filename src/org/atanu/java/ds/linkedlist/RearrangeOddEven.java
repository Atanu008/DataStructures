package org.atanu.java.ds.linkedlist;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class RearrangeOddEven {

    public static Node rearrangeOddEven(Node head) {
        Node even = null, evenTail = null;
        Node odd = null, oddTail = null;
        Node current = head;

        while (current != null) {
            if ((current.data & 1) != 0)//Node is odd
            {
                if (odd == null) {
                    odd = oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = oddTail.next;
                }
            } else {
                if (even == null) {
                    even = evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = evenTail.next;
                }
            }
            current = current.next;
        }

        if (even != null)// Atleast One even
        {
            head = even;
            evenTail.next = odd;
        } else {
            head = odd;
        }

        if (oddTail != null)
            oddTail.next = null;


        return head;
    }

    public static Node reArrange(Node head, Node odd, Node even, Node oddRef) {

        if (head == null) {
            even.next = oddRef.next;
            odd.next = null;
            return head;
        }

        if ((head.data & 1) != 0) {
            odd.next = head;
            reArrange(head.next, head, even, oddRef);
        } else {
            even.next = head;
            reArrange(head.next, odd, head, oddRef);
        }

        return head;
    }

    public static Node rearrangeOddEvenRec(Node head) {

        Node even = new LinkedList().new Node();
        Node odd = new LinkedList().new Node();

        reArrange(head, odd, even, odd);

        return even.next;
    }

    public static void main(String[] args) {
        LinkedList linkedListA = new LinkedList();

        linkedListA.push(2);
        linkedListA.append(3);
        linkedListA.append(1);
        linkedListA.append(4);

        LinkedList.printList(linkedListA.head);

        System.out.println("");

        //Node changedHead = rearrangeOddEven(linkedListA.head);

        Node changedHead = rearrangeOddEvenRec(linkedListA.head);
        LinkedList.printList(changedHead);

        System.out.println("");
        System.out.println(changedHead.next.next.data);

    }

}
