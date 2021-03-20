package org.atanu.java.ds.binarytree;

import java.util.Stack;

public class PrintSpiral {

    public static void printSpiral(TreeNode root) {

        Stack<TreeNode> firstStack = new Stack<>();
        Stack<TreeNode> secondStack = new Stack<>();

        firstStack.push(root);

        while (!firstStack.isEmpty() || !secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                TreeNode curr = firstStack.pop();

                System.out.print(curr.data + " ");

                // Just Change the left right node to change the sequence
                if (curr.right != null) {
                    secondStack.push(curr.right);
                }
                if (curr.left != null) {
                    secondStack.push(curr.left);
                }

            }

            while (!secondStack.isEmpty()) {
                TreeNode curr = secondStack.pop();

                System.out.print(curr.data + " ");

                if (curr.left != null) {
                    firstStack.push(curr.left);
                }
                if (curr.right != null) {
                    firstStack.push(curr.right);
                }

            }
        }
    }


    // Function to print all nodes of a given level from left to right
    public static boolean printLevelLeftToRight(TreeNode root, int level) {
        if (root == null) {
            return false;
        }

        if (level == 1) {
            System.out.print(root.data + " ");
            return true;
        }

        // process left child before right child
        boolean left = printLevelLeftToRight(root.left, level - 1);
        boolean right = printLevelLeftToRight(root.right, level - 1);

        return left || right;
    }

    // Function to print all nodes of a given level from right to left
    public static boolean printLevelRightToLeft(TreeNode root, int level) {
        if (root == null) {
            return false;
        }

        if (level == 1) {
            System.out.print(root.data + " ");
            return true;
        }

        // process right child before left child
        boolean right = printLevelRightToLeft(root.right, level - 1);
        boolean left = printLevelRightToLeft(root.left, level - 1);

        return right || left;
    }

    // Function to print level order traversal of given binary tree
    public static void spiralOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        // start from level 1 -- till height of the tree
        int level = 1;

        // run till either function returns false
        while (printLevelLeftToRight(root, level++) &&
                printLevelRightToLeft(root, level++)) ;
    }

    public static void main(String[] args) {
		
		/* Construct below tree
        1
     /     \
    2       3
   / \     / \
  4   5   6   7
		 */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        printSpiral(root);

        System.out.println();

        spiralOrderTraversal(root);
    }

}
