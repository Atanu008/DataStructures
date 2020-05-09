package org.atanu.java.ds.binarytree;

import java.util.Stack;

public class PreOrderTraversal {

	public static void preOrderRecursive(TreeNode root) {

		// return if the current node is empty
		if(root == null)
			return;

		// Display the data part of the root (or current node)
		System.out.print(root.data +" ");

		// Traverse the left subtree
		preOrderRecursive(root.left);

		// Traverse the right subtree
		preOrderRecursive(root.right);
	}

	public static void preOrderIterative(TreeNode root) {

		// return if the current node is empty
		if(root == null)
			return;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty())
		{
			TreeNode poppedSubRoot = stack.pop();

			System.out.print(poppedSubRoot.data +" ");

			if(poppedSubRoot.right != null)
			{
				stack.push(poppedSubRoot.right);
			}

			if(poppedSubRoot.left != null)
			{
				stack.push(poppedSubRoot.left);
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

		System.out.println("Recursive PreOrder Traversal");
		preOrderRecursive(root);

		System.out.println("\nIterative PreOrder Traversal");
		preOrderIterative(root);

	}
}
