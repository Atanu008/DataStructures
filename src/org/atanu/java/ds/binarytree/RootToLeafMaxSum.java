package org.atanu.java.ds.binarytree;

public class RootToLeafMaxSum {

	public static boolean printPath(TreeNode root , int sum) {
		
		if(sum == 0) {
			return true;
		}
		
		if(root == null) {
			return false;
		}
		
		boolean left = printPath(root.left, sum - root.data);
		boolean right = printPath(root.right, sum - root.data);
		
		if(left || right)
			System.out.print(root.data+ " ");
		
		return left || right;
	}
	
	public static int rootToLeafMaxSum(TreeNode root) {
		
		if(root == null) {
			
			return 0;
		}
		
		int left = rootToLeafMaxSum(root.left);
		
		int right = rootToLeafMaxSum(root.right);
		
		return (left > right ? left : right) + root.data;
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
	
	int maxrootToLeafSum = rootToLeafMaxSum(a);
	
	System.out.println("Maximum Root To Leaf Sum "+ maxrootToLeafSum);
	System.out.print("Path : ");
	printPath(a, maxrootToLeafSum);
	
	}

}
