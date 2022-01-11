package org.atanu.java.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/intersection-of-two-linked-lists/
//LeetCode 160
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> setA = new HashSet<>();
        while(headA != null){
            setA.add(headA);
            headA = headA.next;
        }

        while(headB != null){
            if(setA.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

    //Check the video solution in LeetCode solution.
    public ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {

        ListNode ptA = headA;
        ListNode ptB = headB;

        while(ptA != ptB){

            ptA = ptA == null ? headB : ptA.next;
            ptB = ptB == null ? headA : ptB.next;
        }

        return ptA;
    }
}
