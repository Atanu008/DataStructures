package org.atanu.java.ds.binarysearchtree;

public class LCAInBST {

	
	private static TreeNode LCARecursive(TreeNode root, int x, int y) {
		
		// base case: empty tree
		if(root == null) {
			return null;
		}
		
		// if both x and y is smaller than root, LCA exists in left subtree
		if(root.data > Math.max(x, y)) {
			return LCARecursive(root.left, x, y);
		}
		
		// if both x and y is greater than root, LCA exists in right subtree
		if(root.data < Math.min(x, y)) {
			return LCARecursive(root.right, x, y);
		}
		
		// if one key is greater (or equal) than root and one key is smaller
		// (or equal) than root, then the current node is LCA
		return root;
	}
	
	
	public static boolean search(TreeNode root , int key) {

		if(root == null) {
			return false;
		}

		if(root.data == key) {

			return true;
		}
		if(key < root.data) {

			return search(root.left, key);
		}
		else

			return	search(root.right, key);

	}

	public static void LCAInBST(TreeNode root, int x, int y) {

		// return if tree is empty or either x or y is not present 
		// in the tree
		if(root == null || ! search(root, x) || ! search(root, y)) {
			return;
		}

		// lca stores lowest common ancestor of x and y
		TreeNode lca = LCARecursive(root, x, y);

		// if lowest common ancestor exists, print it
		if (lca != null) {
			System.out.println("LCA is " + lca.data);
		}
		else {
			System.out.println("LCA do not exist");
		}
	}

	

	public static void main(String[] args) {
		
		TreeNode root = null;
		int[] keys = { 15, 10, 20, 8, 12, 16, 25 };

		for (int key: keys) {
			root = TreeNode.insertRecursive(root, key);
		}
		
		LCAInBST(root, 8 , 12);

	}

}
