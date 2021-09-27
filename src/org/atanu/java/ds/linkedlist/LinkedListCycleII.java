package org.atanu.java.ds.linkedlist;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/linked-list-cycle-ii/
//LeetCode 142
//Why Floyd's Cycle Detection Algorithm Works https://www.youtube.com/watch?v=Cs3KwAsqqn4
public class LinkedListCycleII {

    public Node detectCycle(Node head) {
        Node fastPointer = head;
        Node slowPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            // If loop exists. Start slow from
            // head and fast from meeting point.
            if (slowPointer == fastPointer) {
                slowPointer = head;
                while(slowPointer != fastPointer){
                    slowPointer = slowPointer.next;
                    fastPointer = fastPointer.next;
                }
                return slowPointer;
            }
        }

        return null;
    }

    public Node detectCycleV2(Node head) {

        Set<Node> set = new HashSet<>();
        Node curr = head;

        while(curr != null){

            if(set.contains(curr)){
                return curr;
            }

            set.add(curr);
            curr = curr.next;
        }

        return null;
    }

}
