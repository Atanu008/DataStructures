package org.atanu.java.ds.binarytree;

public class CountNodesOfBinaryTree {


	public static int countNodes(TreeNode root) {

		if(root == null)
			return 0;

		int leftTreeCount = countNodes(root.left);

		int righTreeCount = countNodes(root.right);

		return  1 + leftTreeCount + righTreeCount ;
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

		int noOfNodes = countNodes(root);

		System.out.println("No of Nodes in Binary the Tree is "+ noOfNodes);

	}

}
