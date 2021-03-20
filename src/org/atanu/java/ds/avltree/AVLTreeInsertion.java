package org.atanu.java.ds.avltree;

public class AVLTreeInsertion {


    public static TreeNode insert(TreeNode root, int key) {

        /* Perform the normal BST insertion */
        if (root == null) {

            return new TreeNode(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        }

        if (key > root.data) {
            root.right = insert(root.right, key);
        } else // Duplicate keys not allowed
            return root;

        /* Update height of this ancestor node */
        root.height = 1 + Math.max(height(root.left), height(root.right));

		/* Get the balance factor of this ancestor 
        node to check whether this node became 
        unbalanced */
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < root.left.data) {

            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && key > root.right.data) {

            return leftRotate(root);
        }

        // Left Right Case
        if (balance > 1 && key > root.left.data) {

            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case
        if (balance < -1 && key < root.right.data) {

            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        /* return the (unchanged) node pointer */
        return root;

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

        // Return new root
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

        // Return new root
        return b;

    }

    public static int height(TreeNode node) {

        if (node == null) {
            return 0;
        }

        return node.height;
    }

    // Get Balance factor of node
    public static int getBalance(TreeNode node) {
        if (node == null) {
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
    }

}
