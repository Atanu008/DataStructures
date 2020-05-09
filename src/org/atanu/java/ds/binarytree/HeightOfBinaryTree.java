package org.atanu.java.ds.binarytree;

public class HeightOfBinaryTree {

	public static int heightOfBinaryTree(TreeNode root) {

		if(root == null)
			return -1;

		int leftTreeHeight = heightOfBinaryTree(root.left);

		int rightTreeHeight = heightOfBinaryTree(root.right);

		return  1 + Math.max(leftTreeHeight , rightTreeHeight);

	}
	
	  static int height(TreeNode node) 
	    { 
	        /* base case tree is empty */
	        if (node == null) 
	            return 0; 
	  
	        /* If tree is not empty then height = 1 + max of left 
	           height and right heights */
	        return (1 + Math.max(height(node.left), height(node.right))); 
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

		int height = heightOfBinaryTree(root);

		System.out.println("Height of the Binary the Tree is "+ height);
		
		System.out.println("Height of the Binary the Tree is "+ height(root));
	}

}
