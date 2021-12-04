package org.atanu.java.ds.linkedlist;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/copy-list-with-random-pointer/
//LeetCode 138
public class CopyListWithRandomPointer {

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        if(head == null){
            return null;
        }

        Map<Node, Node> cloneMap = new HashMap<>();

        Node start = head;
        while(start != null){
            Node clonnedNode = new Node(start.val);
            cloneMap.put(start, clonnedNode);
            start = start.next;
        }

        start = head;
        while(start != null){
            Node clonnedNode = cloneMap.get(start);
            clonnedNode.next =  cloneMap.get(start.next);
            clonnedNode.random =  cloneMap.get(start.random);
            start = start.next;
        }

        return cloneMap.get(head);
    }

    //TC O(N)
    //SC O(1)
    public Node copyRandomListV2(Node head) {

        if(head == null){
            return null;
        }

        Node ptr = head;

        // Creating a new weaved list of original and copied nodes.
        while(ptr != null){

            Node newNode = new Node(ptr.val);

            // Inserting the cloned node just next to the original node.
            // If A->B->C is the original linked list,
            // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = ptr.next.next;
        }

        // Now link the random pointers of the new nodes created.
        // Iterate the newly created list and use the original nodes' random pointers,
        // to assign references to random pointers for cloned nodes.
        ptr = head;
        while(ptr != null){
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        // Unweave the linked list to get back the original linked list and the cloned list.
        // i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
        ptr = head;
        Node dummyNode = new Node(0);
        Node copy = dummyNode;

        while(ptr != null){

            Node originalNext = ptr.next.next;

            // extract the copy
            copy.next = ptr.next;
            copy = copy.next;

            // restore the original list
            ptr.next = originalNext;
            //Move the ptr
            ptr = originalNext;
        }

        return dummyNode.next;

    }
}
