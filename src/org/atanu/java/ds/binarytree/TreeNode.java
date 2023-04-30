package org.atanu.java.ds.binarytree;

public class TreeNode {

    public int val;
    public TreeNode left, right;

    // Function to create a new binary tree node having given key
    public TreeNode(int key) {
        val = key;
        left = right = null;
    }

    public static void inOrder(TreeNode root) {

        if (root == null) {
            return;
        }
        inOrder(root.left);

        System.out.print(root.val + " ");

        inOrder(root.right);
    }

    public static void preOrder(TreeNode root) {

        // return if the current node is empty
        if (root == null)
            return;

        // Display the data part of the root (or current node)
        System.out.print(root.val + " ");

        // Traverse the left subtree
        preOrder(root.left);

        // Traverse the right subtree
        preOrder(root.right);
    }

    public static void postOrder(TreeNode node) {

        // return if the current node is empty
        if (node == null)
            return;

        // Traverse the left subtree
        postOrder(node.left);

        // Traverse the right subtree
        postOrder(node.right);

        // Display the data part of the root (or current node)
        System.out.print(node.val + " ");

    }
}