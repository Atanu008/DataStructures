package org.atanu.java.ds.linkedlist;

//https://leetcode.com/problems/palindrome-linked-list/
//LeetCode 234
public class PalindromeLinkedList {

    //My Favourite Solution :)
    ListNode leftNode;
    public boolean isPalindrome(ListNode head) {
        leftNode = head;
        return isPalindromeList(head);
    }

    public boolean isPalindromeList(ListNode rightNode) {
        if(rightNode == null) {
            return true;
        }

        boolean interMediateCheck = isPalindromeList(rightNode.next);
        if(!interMediateCheck)
            return false;
        boolean result = leftNode.val == rightNode.val;
        leftNode = leftNode.next;
        return result;
    }


    //https://www.educative.io/courses/grokking-the-coding-interview/JERG3q0p912
    public boolean isPalindromeV2(ListNode head) {
        if (head == null || head.next == null)
            return true;

        // find middle of the LinkedList
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headSecondHalf = reverse(slow); // reverse the second half
        ListNode copyHeadSecondHalf = headSecondHalf; // store the head of reversed part to revert back later

        // compare the first and the second half
        while (head != null && headSecondHalf != null) {
            if (head.val != headSecondHalf.val) {
                break; // not a palindrome
            }
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }

        reverse(copyHeadSecondHalf); // revert the reverse of the second half
        // if both halves match
        return head == null || headSecondHalf == null;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
