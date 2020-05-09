package org.atanu.java.ds.binarytree;

public class CheckSymmetric {

	public static boolean isSymmetric(TreeNode a , TreeNode b) {
		
		if( a == null && b == null) {
			return true;
		}
		
		if( a == null || b == null) {
			return false;
		}
		
		return isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
		
	}
	public static void main(String[] args) {
		   /* Construct below tree
        1
      /   \
     /     \
    2       3
   / \     / \
  4   5   6   7   */

	TreeNode a = new TreeNode(1);
	a.left = new TreeNode(2);
	a.right = new TreeNode(3);
	a.left.left = new TreeNode(4);
	a.left.right = new TreeNode(5);
	a.right.left = new TreeNode(6);
	a.right.right = new TreeNode(7);
	
	TreeNode b = new TreeNode(9);
	b.left = new TreeNode(8);
	b.right = new TreeNode(2);
	b.left.left = new TreeNode(7);
	b.left.right = new TreeNode(6);
	b.right.left = new TreeNode(5);
	b.right.right = new TreeNode(4);
	//b.right.right.left = new TreeNode(100); // This line will make symmetric to false


	boolean result = isSymmetric(a, b);
	
    System.out.println("They are Symmetric Tree "+ result);

	}

}
