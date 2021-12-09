package org.atanu.java.ds.linkedlist;

//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
//LeetCode 1290
//LeetCode Sol : https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/solution/
public class ConvertBinaryNumberInALinkedListToInteger {

    public int getDecimalValue(ListNode head) {

        int num = 0;

        while (head != null) {
            num *= 2;
            num += head.val;
            head = head.next;
        }

        return num;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
