package org.atanu.java.ds.binarytree;

import java.util.HashMap;
import java.util.Map;

class BalanceStatusWithHeight{
	
	int height;
	boolean isBalanced;
	
	public BalanceStatusWithHeight(boolean isBalanced, int height) {
		
		this.isBalanced = isBalanced;
		this.height = height;
	}

	
	
}
public class BalancedBinaryTree {

	public static boolean isBalancedTree(TreeNode root) {
		
	return	checkBalanced(root).isBalanced;
		
	}
	//This is a postorder traversal (left right node) with possible early termination if any left subtree turns out unbalanced and an early result bubbles back up.
	private static BalanceStatusWithHeight checkBalanced(TreeNode root) {
		
		if(root == null) {
			
			return new BalanceStatusWithHeight(true , -1);
		}
		
		BalanceStatusWithHeight leftResult = checkBalanced(root.left);
		if(!leftResult.isBalanced) {
			
			return leftResult;
		}
		
		BalanceStatusWithHeight rightResult = checkBalanced(root.right);
		if(!rightResult.isBalanced) {
			
			return rightResult;
		}
		
		boolean subtreesAreBalanced  = Math.abs(leftResult.height - rightResult.height) <= 1;
		int height = Math.max(leftResult.height, rightResult.height) + 1;
		
		return new BalanceStatusWithHeight(subtreesAreBalanced, height);
		
	}
	public static boolean isBalanced(TreeNode root) {
		
		if(root == null) {
			return true;
		}
		
		Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
		
		int leftHeight = height(root.left, map);
		int rightHeight = height(root.right, map);
		
		
		return Math.abs(leftHeight - rightHeight) <=1 && isBalanced(root.left)  && isBalanced(root.right);
		
	}
	
	public static int height(TreeNode root, Map<TreeNode, Integer> map) {

		if(root == null)
			return -1;

		if(!map.containsKey(root)) {
		int leftTreeHeight = height(root.left , map);

		int rightTreeHeight = height(root.right, map);
		
		map.put(root, 1 + Math.max(leftTreeHeight , rightTreeHeight));
		}

		return  map.get(root);

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
		//root.right.left.right.left = new TreeNode(10);
		//root.right.left.right.left.right = new TreeNode(40);
		
		if (isBalanced(root)) {
			System.out.println("Yes Balanced");
		} else {
			System.out.println("No Balanced");
		}

		if (isBalancedTree(root)) {
			System.out.print("Yes Balanced");
		} else {
			System.out.print("No Balanced");
		}
	}

}
