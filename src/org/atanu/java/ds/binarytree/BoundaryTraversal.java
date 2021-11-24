package org.atanu.java.ds.binarytree;

public class BoundaryTraversal {

    static void printLeaves(TreeNode node)
    {
        if (node == null)
            return;

        printLeaves(node.left);
        // Print it if it is a leaf node
        if (node.left == null && node.right == null)
            System.out.print(node.val + " ");
        printLeaves(node.right);
    }

    // A function to print all left boundary nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    static void printBoundaryLeft(TreeNode node)
    {
        if (node == null)
            return;

        if (node.left != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
            System.out.print(node.val + " ");
            printBoundaryLeft(node.left);
        }
        else if (node.right != null) {
            System.out.print(node.val + " ");
            printBoundaryLeft(node.right);
        }

        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    // A function to print all right boundary nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    static void printBoundaryRight(TreeNode node)
    {
        if (node == null)
            return;

        if (node.right != null) {
            // to ensure bottom up order, first call for right
            // subtree, then print this node
            printBoundaryRight(node.right);
            System.out.print(node.val + " ");
        }
        else if (node.left != null) {
            printBoundaryRight(node.left);
            System.out.print(node.val + " ");
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    // A function to do boundary traversal of a given binary tree
    static void printBoundary(TreeNode node)
    {
        if (node == null)
            return;

        System.out.print(node.val + " ");

        // Print the left boundary in top-down manner.
        printBoundaryLeft(node.left);

        // Print all leaf nodes
        printLeaves(node.left);
        printLeaves(node.right);

        // Print the right boundary in bottom-up manner
        printBoundaryRight(node.right);
    }

    public static void main(String[] args) {

        /*
         * TreeNode root = new TreeNode(1); root.left = new TreeNode(2); root.left.right
         * = new TreeNode(5); root.left.right.left = new TreeNode(8);
         * root.left.right.right = new TreeNode(4); root.right = new TreeNode(3);
         * root.right.right = new TreeNode(7); root.right.right.left = new TreeNode(17);
         * root.right.left = new TreeNode(6); root.right.left.right = new TreeNode(16);
         * boundaryTraversal(root);
         */

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.right.right = new TreeNode(25);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.left.right.left.left = new TreeNode(10);
        printBoundary(root);

    }

}
