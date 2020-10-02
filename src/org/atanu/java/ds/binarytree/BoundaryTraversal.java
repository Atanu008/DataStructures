package org.atanu.java.ds.binarytree;

public class BoundaryTraversal {

	public static void boundaryTraversal(TreeNode root) {

		System.out.print(root.data + " ");

		printLeftBoundary(root.left);
		printLeaveNodes(root);
		printRightBoundary(root.right);
	}

	public static void printLeftBoundary(TreeNode node) {

		if (node == null) {
			return;
		}
		if(node.left != null && node.right != null){
			System.out.print(node.data + " ");
		}
		if (node.left != null) {
			printLeftBoundary(node.left);
		}
		if (node.right != null) {
			printLeftBoundary(node.right);
		}

	}

	public static void printRightBoundary(TreeNode node) {

		if (node == null) {
			return;
		}
		if (node.right != null) {
			printLeftBoundary(node.right);
		}
		if (node.left != null) {
			printLeftBoundary(node.left);
		}
		if(node.left != null && node.right != null){
			System.out.print(node.data + " ");
		}

	}

	// Print Leave Nodes in InOrder Fashion
	public static void printLeaveNodes(TreeNode node) {

		if (node == null) {
			return;
		}
		printLeaveNodes(node.left);

		if (node.left == null && node.right == null) {
			System.out.print(node.data + "L ");
		}

		printLeaveNodes(node.right);

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
		boundaryTraversal(root);

	}

}
