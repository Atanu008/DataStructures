package org.atanu.java.ds.binarytree;

public class CheckSumTree {

	//Idea is to traverse the tree in postOrder fashion
	// Recursive function to check if given binary tree is a sum tree or not
	public static int isSumTree(TreeNode root){

		// base case: empty tree
		if(root == null){
			return 0;
		}

		// special case: leaf node
		if(root.left == null && root.right == null){
			return root.data;
		}

		// if root's value is equal to sum of all elements present in its
		// left and right subtree
		if(root.data == isSumTree(root.left) + isSumTree(root.right)) {

			return 2*root.data;	
		}

		return Integer.MIN_VALUE;
	}


	public static int isSumTreeSol2(TreeNode root){
		// base case: empty tree
		if(root == null){
			return 1;
		}

		// special case: leaf node
		if(root.left == null && root.right == null){
			return 1;
		}

		int leftSum = sum(root.left);

		int rightSum = sum(root.right);

		// if root's value is equal to sum of all elements present in its
		// left and right subtree
		if((root.data == leftSum + rightSum) && (isSumTreeSol2(root.left) != 0) && (isSumTreeSol2(root.right) != 0)	) {
			return 1;
		}

		return 0;
	}

	public static int sum(TreeNode root){

		// base case: empty tree
		if(root == null){
			return 0;
		}

		return root.data + sum(root.left) +  sum(root.right);

	}
	public static void main(String[] args) {

		/* Construct below tree
        44
       /  \
      /    \
     9     13
    / \    / \
   4   5  6   7

		 */

		TreeNode root = new TreeNode(44);
		root.left = new TreeNode(9);
		root.right = new TreeNode(13);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		//root.right.right.left = new TreeNode(30); // Added for Not Sum Tree Test
		//root.right.right.right = new TreeNode(50);

		if (isSumTree(root) != Integer.MIN_VALUE) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

		if (isSumTreeSol2(root) != 0) 
			System.out.println("The given tree is a sum tree"); 
		else
			System.out.println("The given tree is not a sum tree"); 
	}

}
