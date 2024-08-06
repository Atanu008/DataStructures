package org.bgd.java.ds.tree.binarytree;

/**
 *
 * <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii">...</a>
 *
 * Given a binary tree
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 */
public class PopulateRightPointerII {
    public Node connect(Node root) {
        Node dummy = new Node(0);
        Node prev = dummy;
        Node ret = root;

        while(root != null) {
            if(root.left != null) {
                prev.next = root.left;
                prev = prev.next;
            }

            if(root.right != null) {
                prev.next = root.right;
                prev = prev.next;
            }

            root = root.next;
            if(root == null) {
                prev = dummy;
                root = dummy.next;
                dummy.next = null;
            }
        }

        return ret;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
