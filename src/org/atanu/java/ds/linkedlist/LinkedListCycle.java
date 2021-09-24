package org.atanu.java.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

//https://leetcode.com/problems/linked-list-cycle/
//LeetCode 141
public class DetectCycle {

    public static boolean hasCycle(Node head) {

        Set<Node> set = new HashSet();
        Node node = head;
        while (node != null) {
            // return false if we already have seen this node before
            if (set.contains(node)) {
                return true;
            }
            // insert the current node into the set
            set.add(node);
            // move to the next node
            node = node.next;

        }
        return false;
    }

    // Method to detect a cycle in a linked list using
    // Floyd’s cycle detection algorithm
    public static boolean hasCycleV2(Node head) {

        // take two references – `slow` and `fast`
        Node slowPoniter = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            // move slow by one
            // move fast by two
            slowPoniter = slowPoniter.next;
            fastPointer = fastPointer.next.next;
            // if they meet any node, the linked list contains a cycle
            if (slowPoniter == fastPointer)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Node head = null;
        LinkedList linkedList = new LinkedList();

        for (int i = 5; i > 0; i--) {
            head = linkedList.new Node(i, head);
        }

        linkedList.printList(head);
        head.next.next.next.next.next = head.next.next;
        System.out.println(hasCycle(head));
        System.out.println(hasCycleV2(head));
        //linkedList.printList(head);
    }

}
