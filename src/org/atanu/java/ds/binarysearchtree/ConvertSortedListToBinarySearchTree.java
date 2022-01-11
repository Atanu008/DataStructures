package org.atanu.java.ds.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
//LeetCode 109
public class ConvertSortedListToBinarySearchTree {


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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        // If the head doesn't exist, then the linked list is empty
        if (head == null) {
            return null;
        }
        // Find the middle element for the list.
        ListNode mid = getMiddleElement(head);
        // The mid becomes the root of the BST.
        TreeNode root = new TreeNode(mid.val);
        // Base case when there is just one element in the linked list
        if (mid == head) {
            return root;
        }

        // Recursively form balanced BSTs using the left and right halves of the original list
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);

        return root;
    }

    private ListNode getMiddleElement(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //Disconnect the first half. to get proper mid of the first half in next recursion
        if (prev != null) {
            prev.next = null;
        }

        return slow;
    }

    //Recursion + Conversion to Array
    private List<Integer> values;
    private void mapListToValues(ListNode head) {
        while (head != null) {
            this.values.add(head.val);
            head = head.next;
        }
    }

    private TreeNode convertListToBST(int left, int right) {
        // Invalid case
        if (left > right) {
            return null;
        }

        // Middle element forms the root.
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(this.values.get(mid));

        // Base case for when there is only one element left in the array
        if (left == right) {
            return node;
        }

        // Recursively form BST on the two halves
        node.left = convertListToBST(left, mid - 1);
        node.right = convertListToBST(mid + 1, right);
        return node;
    }

    public TreeNode sortedListToBSTV2(ListNode head) {

        // Form an array out of the given linked list and then
        // use the array to form the BST.
        this.values = new ArrayList<Integer>();
        this.mapListToValues(head);

        // Convert the array to
        return convertListToBST(0, this.values.size() - 1);
    }
}
