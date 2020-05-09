package org.atanu.java.ds.binarysearchtree;

public class InOrderPredecessor {


	private static TreeNode inOrderPredecessorRecursive(TreeNode root, TreeNode prec, int key) {


		if(root == null) {
			return null;
		}

		// Case 1 : Left sub tree is present
		if(root.data == key) {

			// Node has Left sub Tree. return rightmost(Max)node of Right sub tree
			if(root.left != null) {
				return getMax(root.left);
			}
		}

		// Case 2 : Left sub tree is NOT present

		if(key < root.data) {
			return inOrderPredecessorRecursive(root.left, prec, key);
		}

		// Node will be in the right sub tree of the Predecessor
		else if(key > root.data) {
			
			prec = root;
			return inOrderPredecessorRecursive(root.right, prec, key);
		}

		return prec;
	}
	
	
public static TreeNode inOrderPredecessorIterative(TreeNode root , TreeNode succ ,int key) {
		
		if(root == null) {
			return null;
		}
		
		TreeNode curr = find(root, key);
		
		if(curr == null) {
			return null;
		}
		
		// Case 1 : Right sub tree is present
		if(curr.left != null)
		{
			return getMax(curr.left);
		}
		
		// Case 2 : Right sub tree is NOT present
		
		TreeNode ancestor = root;
		TreeNode predecessor = null;
		
		while(ancestor != curr)
		{
			if(curr.data < ancestor.data) {
				
				ancestor = ancestor.left;
			}
			else {
				predecessor = ancestor;
				ancestor = ancestor.right;
			}
		}
		
		return predecessor;
		
}
	

private static TreeNode find(TreeNode root, int key) {

	if(root == null) {
		return null;
	}
	
	if(root.data == key) {
		return root;
	}
	
	if(key < root.data) {
		return find(root.left, key);
	}
	
	else
		return find(root.right, key);
}

	public static TreeNode getMax(TreeNode root) {

		if(root == null) {

			System.out.println("Empty tree");
			System.exit(-1);
		}

		while(root.right != null)
		{
			root = root.right;
		}

		return root;

	}
	public static void main(String[] args) {
		/* Construct below tree
		   15
		 /	\
		/	  \
	   10	   20
	  /  \	   / \
	 /	  \   /	  \
	8	 12  16	  25
		 */
		TreeNode root = null;
		int[] keys = { 15, 10, 20, 8, 12, 16, 25 };

		for (int key: keys) {
			root = TreeNode.insertRecursive(root, key);
		}

		TreeNode.inOrder(root);

		System.out.println("\nPrinting Recursive");
		// find in-order successor for each key
		for (int key : keys)
		{
			TreeNode prec = inOrderPredecessorRecursive(root, null, key);

			if (prec != null) {
				System.out.println("Predecessor of node " + key + " is "
						+ prec.data);
			} else {
				System.out.println("Predecessor doesn't exists for node "
						+ key);
			}
		}

		System.out.println("\nPrinting Iterative");
		// find in-order successor for each key
				for (int key : keys)
				{
					TreeNode prec = inOrderPredecessorIterative(root, null, key);

					if (prec != null) {
						System.out.println("Predecessor of node " + key + " is "
								+ prec.data);
					} else {
						System.out.println("Predecessor doesn't exists for node "
								+ key);
					}
				}
	}


}
