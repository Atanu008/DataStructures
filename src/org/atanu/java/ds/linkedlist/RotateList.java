package org.atanu.java.ds.linkedlist;

//https://leetcode.com/problems/rotate-list/
//LeetCode 61
//right Rotation
//https://www.educative.io/courses/grokking-the-coding-interview/gkAM9kxgY8Z
public class RotateList {

    public ListNode rotateRight(ListNode head, int rotations) {

        if(head == null || head.next == null || rotations <= 0) {
            return head;
        }

        // find the length and the last node of the list
        ListNode lastNode = head;
        int listLength = 1;
        while(lastNode != null && lastNode.next != null){
            listLength++;
            lastNode = lastNode.next;
        }

        // connect the last node with the head to make it a circular list
        lastNode.next = head;
        // no need to do rotations more than the length of the list
        rotations = rotations % listLength;
        int skipLength = listLength - rotations;

        ListNode lastNodeOfRotatedList = head;

        for(int i = 0; i < skipLength -1; i++){
            lastNodeOfRotatedList = lastNodeOfRotatedList.next;
        }
        // 'lastNodeOfRotatedList.next' is pointing to the sub-list of 'k' ending nodes
        head = lastNodeOfRotatedList.next;
        lastNodeOfRotatedList.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = new RotateList().rotateRight(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
