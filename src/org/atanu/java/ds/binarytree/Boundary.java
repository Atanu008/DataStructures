package org.atanu.java.ds.binarytree;

//Java program to print boundary traversal of binary tree 

/* A binary tree node has data, pointer to left child 
and a pointer to right child */


class Boundary {
    TreeNode root;

    // A simple function to print leaf nodes of a binary tree
    void printLeaves(TreeNode node) {
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
    void printBoundaryLeft(TreeNode node) {
        if (node == null)
            return;

        if (node.left != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
            System.out.print(node.val + " ");
            printBoundaryLeft(node.left);
        } else if (node.right != null) {
            System.out.print(node.val + " ");
            printBoundaryLeft(node.right);
        }

        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    // A function to print all right boundary nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(TreeNode node) {
        if (node == null)
            return;

        if (node.right != null) {
            // to ensure bottom up order, first call for right
            // subtree, then print this node
            printBoundaryRight(node.right);
            System.out.print(node.val + " ");
        } else if (node.left != null) {
            printBoundaryRight(node.left);
            System.out.print(node.val + " ");
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    // A function to do boundary traversal of a given binary tree
    void printBoundary(TreeNode node) {
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

    // Driver program to test above functions
    public static void main(String args[]) {
        Boundary tree = new Boundary();
        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.left.left = new TreeNode(99);
        tree.root.left.right.left.left.right = new TreeNode(199);
        tree.root.left.right.right = new TreeNode(14);
        tree.root.right = new TreeNode(22);
        tree.root.right.right = new TreeNode(25);
        tree.printBoundary(tree.root);
    }
} 
