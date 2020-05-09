package org.atanu.java.ds.binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class LevelOrderTraversal {

	public static void levelOrderTraversal(TreeNode root) {
		
		Deque<TreeNode> queue = new LinkedList<>();
		
		queue.add(root);
		
		TreeNode curr;
		while(!queue.isEmpty())
		{
			curr = queue.poll();
			
			System.out.print(curr.data+ " ");
			
			if(curr.left != null)
			{
				queue.add(curr.left);
			}
			
			if(curr.right != null)
			{
				queue.add(curr.right);
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

		System.out.println("Level Order Traversal");
		levelOrderTraversal(root);

	}

}
