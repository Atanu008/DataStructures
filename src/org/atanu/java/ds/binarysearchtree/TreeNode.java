package org.atanu.java.ds.binarysearchtree;

public class TreeNode {

	int data;
	TreeNode left, right;

	// Function to create a new binary tree node having given key
	public TreeNode(int key)
	{
		data = key;
		left = right = null;
	}

	public static void inOrder(TreeNode root) {

		if(root == null) {
			return;
		}
		inOrder(root.left);

		System.out.print(root.data+ " ");

		inOrder(root.right);
	}

	public static TreeNode insertRecursive(TreeNode root, int key) {
		// if the root is null, create a new node an return it
		if(root == null) {

			return new TreeNode(key);
		}

		// if given key is less than the root node,
		// recur for left subtree
		else if(key < root.data) {
			root.left = insertRecursive(root.left, key);
		}
		// else recur for right subtree
		else if(key > root.data) {
			root.right = insertRecursive(root.right, key);
		}

		return root;

	}
}