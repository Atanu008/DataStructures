package org.atanu.java.ds.binarysearchtree;

public class InsertInBinarySearchTree {

    public static TreeNode insertRecursive(TreeNode root, int key) {

        // if the root is null, create a new node an return it
        if (root == null) {

            return new TreeNode(key);
        }

        // if given key is less than the root node,
        // recur for left subtree
        else if (key < root.data) {
            root.left = insertRecursive(root.left, key);
        }
        // else recur for right subtree
        else if (key > root.data) {
            root.right = insertRecursive(root.right, key);
        }

        return root;
    }

    public static TreeNode insertIterative(TreeNode root, int key) {

        // if tree is empty, create a new node and set root
        if (root == null) {

            return new TreeNode(key);
        }

        // start with root node
        TreeNode curr = root;

        // pointer to store parent node of current node
        TreeNode parent = null;

        while (curr != null) {
            // update parent node as current node
            parent = curr;

            // if given key is less than the current node,
            // go to left subtree else go to right subtree
            if (key < curr.data) {
                curr = curr.left;
            } else if (key > curr.data) {
                curr = curr.right;
            }
        }

        // construct a new node and assign to appropriate parent pointer
        if (key < parent.data) {

            parent.left = new TreeNode(key);
        } else {
            parent.right = new TreeNode(key);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        int[] keys = {15, 10, 20, 8, 12, 16, 25};

        for (int key : keys) {
            //root = insertRecursive(root, key);

            root = insertIterative(root, key);
        }

        TreeNode.inOrder(root);
    }

}
