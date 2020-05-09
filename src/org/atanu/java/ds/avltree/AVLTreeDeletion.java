package org.atanu.java.ds.avltree;

public class AVLTreeDeletion {

	public static TreeNode insert(TreeNode root , int key) {

		if(root == null) {

			return new TreeNode(key);
		}

		if(key < root.data) {
			root.left = insert(root.left, key);
		}

		if(key > root.data) {
			root.right = insert(root.right, key);
		}
		else
			return root;

		root.height = 1 + Math.max(height(root.left), height(root.right));

		int balance = getBalance(root);

		if(balance > 1 && key < root.left.data) {

			return rightRotate(root);
		}

		if(balance < -1 && key > root.right.data) {

			return leftRotate(root);
		}

		if(balance > 1 && key > root.left.data) {

			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		if(balance < -1 && key < root.right.data) {

			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;

	}

	public static TreeNode delete(TreeNode root , int key) {

		// STEP 1: PERFORM STANDARD BST DELETE 
		if (root == null) 
			return root; 

		// If the key to be deleted is smaller than 
		// the root's key, then it lies in left subtree 
		if (key < root.data) 
			root.left = delete(root.left, key); 

		// If the key to be deleted is greater than the 
		// root's key, then it lies in right subtree 
		else if (key > root.data) 
			root.right = delete(root.right, key); 

		// if key is same as root's key, then this is the node 
		// to be deleted 
		else
		{
			if(root.left == null || root.right == null) {

				TreeNode temp = null;

				temp = (root.left == null) ? root.right : root.left;

				if(temp == null) {

					root = null;
				}

				else
				{ 

					// node with two children: Get the inorder 
					// successor (smallest in the right subtree) 
					TreeNode temp1 = minValueNode(root.right); 

					// Copy the inorder successor's data to this node 
					root.data = temp1.data; 

					// Delete the inorder successor 
					root.right = delete(root.right, temp1.data); 
				} 
			}
		}

		if(root == null) {
			return null;
		}

		// STEP 2: UPDATE HEIGHT OF THE CURRENT NODE 
		root.height = Math.max(height(root.left), height(root.right)) + 1; 

		// STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether 
		// this node became unbalanced) 
		int balance = getBalance(root); 
		
		// If this node becomes unbalanced, then there are 4 cases 
		// Left Left Case 
		if(balance > 1 && getBalance(root.left) >=0) {
			return rightRotate(root);
		}
		
		// Right Right Case 
		if(balance < -1 && getBalance(root.right) <= 0) {
			return rightRotate(root);
		}
		
		// Left Right Case
		if(balance > 1 && getBalance(root.left) <=0) {
			root.left = leftRotate(root.left); 
			return rightRotate(root); 
		}
		
		//Right left Case 
		if(balance < -1 && getBalance(root.right) >= 0) {
			root.right = rightRotate(root.right); 
			return leftRotate(root);
		}
		
		return root;
		
			
	}

	/* Given a non-empty binary search tree, return the 
	node with minimum key value found in that tree. 
	Note that the entire tree does not need to be 
	searched. */
	public static TreeNode minValueNode(TreeNode node) 
	{ 
		TreeNode current = node; 

		/* loop down to find the leftmost leaf */
		while (current.left != null) 
			current = current.left; 

		return current; 
	} 

	private static TreeNode leftRotate(TreeNode c) {

		TreeNode b = c.right;
		TreeNode T = b.left;

		//rotate
		b.left = c;
		c.right = T;

		//Height Update
		c.height = Math.max(height(c.left), height(c.right));
		b.height = Math.max(height(b.left), height(b.right));

		return b;
	}

	private static TreeNode rightRotate(TreeNode c) {

		TreeNode b = c.left;
		TreeNode T = b.right;

		//rotate
		b.right = c;
		c.left = T;

		//Height Update
		c.height = Math.max(height(c.left), height(c.right));
		b.height = Math.max(height(b.left), height(b.right));

		return b;

	}
	
	public static int height(TreeNode node) {

		if(node == null) {
			return 0;
		}

		return node.height;
	}

	// Get Balance factor of node
	public static int getBalance(TreeNode node) {
		if(node == null) {
			return 0;
		}

		return getBalance(node.left) - getBalance(node.right);
	}

	public static void main(String[] args) {

		/* Constructing tree given in the above figure */
		TreeNode root = null;

		root = insert(root, 10); 
		root = insert(root, 20); 
		root = insert(root, 30); 
		root = insert(root, 40); 
		root = insert(root, 50); 
		root = insert(root, 25); 

		TreeNode.inOrder(root);
		System.out.println();
		
		TreeNode newRoot = delete(root, 25);
		
		TreeNode.inOrder(newRoot);
		
	}
	

}
