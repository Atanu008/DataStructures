package org.atanu.java.ds.binarytree;

import java.util.Stack;

public class PostOrderTraversal {

    private static void postOrderRecursive(TreeNode node) {

        // return if the current node is empty
        if (node == null)
            return;

        // Traverse the left subtree
        postOrderRecursive(node.left);

        // Traverse the right subtree
        postOrderRecursive(node.right);

        // Display the data part of the root (or current node)
        System.out.print(node.data + " ");

    }

    public static void postOrderIterative(TreeNode root) {

        Stack<TreeNode> inStack = new Stack<>();
        Stack<TreeNode> outStack = new Stack<>();

        inStack.push(root);
        while (!inStack.isEmpty()) {
            TreeNode popped = inStack.pop();

            outStack.push(popped);

            if (popped.left != null) {
                inStack.push(popped.left);
            }

            if (popped.right != null) {
                inStack.push(popped.right);
            }
        }

        while (!outStack.isEmpty()) {
            TreeNode outPopped = outStack.pop();
            System.out.print(outPopped.data + " ");
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

        System.out.println("Recursive PostOrder Traversal");
        postOrderRecursive(root);

        System.out.println("\nIterative PostOrder Traversal");
        postOrderIterative(root);
    }

}
