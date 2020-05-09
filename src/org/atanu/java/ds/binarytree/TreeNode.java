package org.atanu.java.ds.binarytree;

public class TreeNode {

	int data;
	TreeNode left, right;

	// Function to create a new binary tree node having given key
	public TreeNode(int key)
	{
		data = key;
		left = right = null;
	}
}