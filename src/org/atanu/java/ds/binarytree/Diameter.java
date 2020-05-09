package org.atanu.java.ds.binarytree;

import java.util.HashMap;
import java.util.Map;

public class Diameter {

	static int  ans;
	public static int getDiameter(TreeNode root) {

		 /* base case if tree is empty */
        if (root == null) 
            return 0; 
  
        /* get the height of left and right sub trees */
        int leftheight = height(root.left); 
        int rightheight = height(root.right); 

        /* get the diameter of left and right subtrees */
        int leftdiameter = getDiameter(root.left); 
        int rrightdiameter = getDiameter(root.right); 
  
        
       int maxWithRoot = leftheight + rightheight; // count no of edges in longest path
        
       //int maxWithRoot = leftheight + rightheight + 1 ; // count no of nodes in longest path
        
        /* Return max of following three 
          1) Diameter of left subtree 
         2) Diameter of right subtree 
         3) Height of left subtree + height of right subtree + 1 */
        return Math.max(maxWithRoot, Math.max(leftdiameter, rrightdiameter)); 
	}

	  static int height(TreeNode node) 
	    { 
	        /* base case tree is empty */
	        if (node == null) 
	            return 0;  // here it is zero because we are counting no of nodes here not edges.
	  
	        /* If tree is not empty then height = 1 + max of left 
	           height and right heights */
	        return (1 + Math.max(height(node.left), height(node.right))); 
	    } 
	


	public static void main(String[] args) {

		/* Construct below tree
        1
     /     \
    2       3
   / \     / \
  4   5   6   7
		 */


		TreeNode root = new TreeNode(1); 
		root.left = new TreeNode(2); 
		root.right =new TreeNode(3); 
		root.left.left = new TreeNode(4); 
		root.left.right = new TreeNode(5); 
		root.right.left = new TreeNode(6); 
		root.right.right = new TreeNode(7); 
		//root.right.right.right = new TreeNode(9);
		//root.right.right.right.left = new TreeNode(12);
		//root.right.right.right.left.right = new TreeNode(20);
		//root.right.right.right.left.right.left = new TreeNode(25);



		System.out.println(height(root));

		System.out.println("Diameter of the tree is "+getDiameter(root));

	}

}
