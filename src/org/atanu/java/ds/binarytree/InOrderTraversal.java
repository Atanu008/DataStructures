package org.atanu.java.ds.binarytree;

import java.util.Stack;

public class InOrderTraversal {


    private static void inOrderRecursive(TreeNode node) {

        // return if the current node is empty
        if (node == null)
            return;

        // Traverse the left subtree
        inOrderRecursive(node.left);

        // Display the data part of the root (or current node)
        System.out.print(node.val + " ");

        // Traverse the right subtree
        inOrderRecursive(node.right);

    }

    public static void InOrderIterative(TreeNode root) {

        // return if the current node is empty
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode popped = stack.pop();
                System.out.print(popped.val + " ");
                curr = popped.right;
            }
        }

    }

    public static void main(String[] args) {


		/* Construct below tree
        1
      /   \
     /     \
    2       3
   / \      / \
  /   \    /   \
 4     5  6     7
         / \
        /   \
       8     9
		 */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(9);

        System.out.println("Recursive InOrder Traversal");
        inOrderRecursive(root);

        System.out.println("\nIterative InOrder Traversal");
        InOrderIterative(root);
    }


}
