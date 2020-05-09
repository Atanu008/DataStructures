package org.atanu.java.ds.binarysearchtree;

public class MinMaxinBST {

	public static int getMin(TreeNode root) {
		
		if(root == null) {
			
			System.out.println("Empty tree");
			System.exit(-1);
		}
		
		while(root.left != null)
		{
			root = root.left;
		}
		
		return root.data;
		
	}
	
	
	public static int getMax(TreeNode root) {
		
		if(root == null) {
			
			System.out.println("Empty tree");
			System.exit(-1);
		}
		
		while(root.right != null)
		{
			root = root.right;
		}
		
		return root.data;
		
	}
	
	public static void main(String[] args) {
		
		TreeNode root = null;
		int[] keys = { 15, 10, 20, 8, 12, 16, 25 };

		for (int key: keys) {
			root = TreeNode.insertRecursive(root, key);
		}
		
		TreeNode.inOrder(root);
		
		
		System.out.println("\nMinimum Element is "+ getMin(root));
		
		System.out.println("Maximum Element is "+ getMax(root));
		

	}

}
