package org.atanu.java.ds.linkedlist;

//https://leetcode.com/problems/split-linked-list-in-parts/
//LeetCode 725
public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode[] splitHeads = new ListNode[k];

        int length = 0;
        ListNode current = head;
        while(current != null){
            length++;
            current = current.next;
        }

        int size =  length / k; // size : minimum guaranteed part size;
        int distribute = length % k; // distribute : extra nodes spread to the first r parts;

        current = head;
        int i = 0;
        while(current != null && i < k){

            splitHeads[i] = current;

            ListNode prev = null;
            for(int j = 0; j < size + (distribute > 0 ? 1: 0) ; j++){
                prev = current;
                current = current.next;
            }

            prev.next = null;
            distribute--;
            i++;
        }

        return splitHeads;
    }
}
