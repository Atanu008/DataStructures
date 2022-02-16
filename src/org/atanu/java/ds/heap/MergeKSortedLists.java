package org.atanu.java.ds.heap;

import java.util.PriorityQueue;

//https://leetcode.com/problems/merge-k-sorted-lists/
//LeetCode 23
//https://www.educative.io/courses/grokking-the-coding-interview/Y5n0n3vAgYK
public class MergeKSortedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int value) {
            this.val = value;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists==null || lists.length==0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // put the root of each list in the min heap
        for(ListNode node : lists) {
            if(node != null){
                minHeap.offer(node);
            }
        }

        // take the smallest (top) element form the min-heap and add it to the result;
        // if the top element has a next element add it to the heap
        ListNode head = null;
        ListNode tail = null;
        while(!minHeap.isEmpty()) {

            ListNode currentMinNode = minHeap.poll();

            if(head == null) {
                head = tail = currentMinNode;
            }
            else{
                tail.next = currentMinNode;
                tail = tail.next;
            }

            if(currentMinNode.next != null) {
                minHeap.offer(currentMinNode.next);
            }
        }

        return head;
    }

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = mergeKSortedLists.mergeKLists(new ListNode[] { l1, l2, l3 });
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
