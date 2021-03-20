package org.atanu.java.ds.binarysearchtree;

public class IsBinarySearchTree {


    // Recursive function to determine if given Binary Tree is a BST or not
    // by keeping a valid range (starting from [MIN_VALUE, MAX_VALUE]) and
    // keep shrinking it down for each node as we go down recursively
    public static boolean isBST(TreeNode root, int minKey, int maxKey) {

        if (root == null) {
            return true;
        }

        // if node's value fall outside valid range
        if (root.data < minKey || root.data > maxKey) {

            return false;
        }

        // recursively check left and right subtrees with updated range
        return isBST(root.left, minKey, root.data) && isBST(root.right, root.data, maxKey);

    }

    public static void isBST(TreeNode root) {

        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.println("This is a BST.");
        } else {
            System.out.println("This is NOT a BST!");
        }

    }

    private static boolean isBinarySearchTree(TreeNode root, TreeNode PrevMinValue) {

        // base case: empty tree is a BST
        if (root == null) {

            return true;
        }

        // check if left subtree is BST or not
        boolean left = isBinarySearchTree(root.left, PrevMinValue);

        // value of current node should be more than that of previous node
        if (root.data <= PrevMinValue.data) {
            return false;
        }

        // update previous node data and check if right subtree is BST or not
        PrevMinValue.data = root.data;

        return left && isBinarySearchTree(root.right, PrevMinValue);
    }


    public static void isBinarySearchTree(TreeNode root) {

        TreeNode PrevMinValue = new TreeNode(Integer.MIN_VALUE);

        if (isBinarySearchTree(root, PrevMinValue)) {
            System.out.println("This is a BST.");
        } else {
            System.out.println("This is NOT a BST!");
        }

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        //root.left.right.right = new TreeNode(9);  // Will evaluate false

        isBST(root);

        isBinarySearchTree(root);

    }

}
