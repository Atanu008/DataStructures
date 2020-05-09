package org.atanu.java.ds.binarysearchtree;

public class InOrderSuccessor {

	public static TreeNode inOrderSuccessorRecursive(TreeNode root , TreeNode succ ,int key) {
		
		if(root == null) {
			return null;
		}
		
		// Case 1 : Right sub tree is present
		if(root.data == key) {
			
			// Node has Right sub Tree. return leftmost(Min) node of Right sub tree
			if(root.right != null)
				return getMin(root.right);
		}
		
		// Case 2 : Right sub tree is NOT present
		
		// Node will be in the left sub tree of the Successor
		if(key < root.data) {
			
			succ = root; // To find the deepest node where key is in the left
			return inOrderSuccessorRecursive(root.left, succ, key);
		}
		
		if(key > root.data) {

			return inOrderSuccessorRecursive(root.right, succ, key);
		}
		
		
		// Returning succ if there is no right sub tree.
		return succ;
		
	}
	
	
public static TreeNode inOrderSuccessorIterative(TreeNode root , TreeNode succ ,int key) {
		
		if(root == null) {
			return null;
		}
		
		TreeNode curr = find(root, key);
		
		if(curr == null) {
			return null;
		}
		
		// Case 1 : Right sub tree is present
		if(curr.right != null)
		{
			return getMin(curr.right);
		}
		
		// Case 2 : Right sub tree is NOT present
		
		TreeNode ancestor = root;
		TreeNode successor = null;
		
		while(ancestor != curr)
		{
			if(curr.data < ancestor.data) {
				
				successor = ancestor;
				ancestor = ancestor.left;
			}
			else {
				ancestor = ancestor.right;
			}
		}
		
		return successor;
		
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


	public static TreeNode getMin(TreeNode root) {
		
		if(root == null) {
			
			System.out.println("Empty tree");
			System.exit(-1);
		}
		
		while(root.left != null)
		{
			root = root.left;
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
					TreeNode prec = inOrderSuccessorRecursive(root, null, key);

					if (prec != null) {
						System.out.println("Successor of node " + key + " is "
											+ prec.data);
					} else {
						System.out.println("Successor doesn't exists for node "
											+ key);
					}
				}
				
				
				System.out.println("\nPrinting Iterative");
				// find in-order successor for each key
						for (int key : keys)
						{
							TreeNode prec = inOrderSuccessorIterative(root, null, key);

							if (prec != null) {
								System.out.println("Successor of node " + key + " is "
													+ prec.data);
							} else {
								System.out.println("Successor doesn't exists for node "
													+ key);
							}
						}

	}

}
