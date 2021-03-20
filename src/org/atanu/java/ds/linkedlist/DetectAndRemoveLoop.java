package org.atanu.java.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class DetectAndRemoveLoop {

    public static boolean detectAndRemoveLoopMethod1(Node head) {

        Set<Node> set = new HashSet();
        Node node = head;
        Node prev = null;
        while (node != null) {
            if (set.contains(node)) {
                prev.next = null;
                return true;
            }

            set.add(node);
            prev = node;
            node = node.next;

        }
        return false;
    }

    public static boolean detectAndRemoveLoopMethod2(Node head) {

        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                removeLoopMethod2(slowPointer, head);
                return true;
            }

        }

        return false;
    }


    private static void removeLoopMethod2(Node loopPointer, Node head) {

        Node pointer1 = head;
        Node pointer2 = loopPointer;

        Node loopMarker = pointer2;

        while (pointer2.next != loopMarker && pointer2.next != pointer1) {
            pointer2 = pointer2.next;
        }

        if (pointer2.next == pointer1) {
            pointer2.next = null;
            return;
        }

        pointer1 = pointer1.next;

        removeLoopMethod2(pointer2, pointer1);// Iterative approach can also be implemented. while(true) and break when the match is found
    }

    public static boolean detectAndRemoveLoopMethod3(Node head) {

        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                removeLoopMethod3(slowPointer, head);
                return true;
            }

        }

        return false;
    }


    private static void removeLoopMethod3(Node loopPointer, Node head) {

        Node pointer1 = head;
        Node pointer2 = loopPointer;

        int loopNodeCount = 1;

        while (pointer2.next != loopPointer) {
            loopNodeCount++;
            pointer2 = pointer2.next;
        }

        pointer2 = head;

        for (int i = 0; i < loopNodeCount; i++) {
            pointer2 = pointer2.next;
        }

        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        pointer2 = pointer2.next;

        while (pointer2.next != pointer1) {
            pointer2 = pointer2.next;
        }

        pointer2.next = null;
        //System.out.println(loopNodeCount);
    }

    public static void main(String[] args) {

        Node head = null;
        LinkedList linkedList = new LinkedList();

        for (int i = 5; i > 0; i--) {
            head = linkedList.new Node(i, head);
        }

        linkedList.printList(head);
        head.next.next.next.next.next = head.next.next;
        //System.out.println(detectAndRemoveLoopMethod1(head));
        //System.out.println(detectAndRemoveLoopMethod2(head));
        detectAndRemoveLoopMethod3(head);
        linkedList.printList(head);
    }

}
