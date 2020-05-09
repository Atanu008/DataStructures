package org.atanu.java.ds.binarytree;

public class BinaryTreeToDLL {

	TreeNode prev = null;
	TreeNode head = null;
	
	public  void binaryTreeToDLL(TreeNode root) {
		
		if(root == null) {
			
			return;
		}
		
		//Recur left
		binaryTreeToDLL(root.left);
		
		if(prev == null) {
			head = root;
		}
		else {
			prev.right = root;
			root.left = prev;
		}
		
		prev = root;
		
		//Recur right
		binaryTreeToDLL(root.right);
		
		
	}
	
	 void printList(TreeNode node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.right;
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

		
		
		BinaryTreeToDLL bt = new BinaryTreeToDLL();
		
		bt.binaryTreeToDLL(root);
		
		bt.printList(bt.head);
	}

}
