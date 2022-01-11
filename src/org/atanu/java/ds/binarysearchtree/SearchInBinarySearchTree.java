package org.atanu.java.ds.binarysearchtree;

public class SearchInBinarySearchTree {

    public static void searchRecursive(TreeNode root, int key) {

        // if key is not present in the key
        if (root == null) {

            System.out.println(key + " is NOT found");
            return;
        }

        // if key is found
        if (root.val == key) {
            System.out.println(key + " is Found");
        }

        // if given key is less than the root node, recur for left subtree
        // else recur for right subtree
        if (key < root.val) {
            searchRecursive(root.left, key);
        } else if (key > root.val) {
            searchRecursive(root.right, key);
        }

    }

    public static boolean searchIterative(TreeNode root, int key) {

        TreeNode curr = root;

        while (curr != null) {
            // Return true if Found
            if (curr.val == key) {
                System.out.println(key + " is Found");
                return true;
            }

            // Move current
            if (key < curr.val) {
                curr = curr.left;
            } else if (key > curr.val) {
                curr = curr.right;
            }

        }

        System.out.println(key + " is NOT found");
        // Return false
        return false;
    }

    public static TreeNode insertRecursive(TreeNode root, int key) {

        if (root == null) {

            return new TreeNode(key);
        } else if (key < root.val) {
            root.left = insertRecursive(root.left, key);
        } else if (key > root.val) {
            root.right = insertRecursive(root.right, key);
        }

        return root;
    }

    public static void main(String[] args) {

        TreeNode root = null;
        int[] keys = {15, 10, 20, 8, 12, 16, 25};

        for (int key : keys) {
            root = insertRecursive(root, key);
        }

        searchRecursive(root, 25);

        searchIterative(root, 24);
    }

}
