package org.atanu.java.ds.binarysearchtree;


//Node to be deleted is leaf: Simply remove from the tree.
//Node to be deleted has only one child: Copy the child to the node and delete the child
//Node to be deleted has two children: Find inorder successor of the node. Copy contents of the inorder successor to the node and delete the inorder successor. Note that inorder predecessor can also be used.

public class DeleteInBinarySearchTree {

    public static TreeNode getMin(TreeNode root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public static TreeNode delete(TreeNode root, int key) {

        // base case: key not found in tree
        if (root == null) {
            return root;
        }

        // if given key is less than the root node, recur for left subtree
        if (key < root.data) {

            root.left = delete(root.left, key);
        }
        // if given key is more than the root node, recur for right subtree
        else if (key > root.data) {

            root.right = delete(root.right, key);
        }

        // key found
        else {

            // Case 1: node to be deleted has no children (it is a leaf node)
            if (root.left == null && root.right == null) {

                return null;
            }

            // Case 2: node to be deleted has two children
            else if (root.left != null && root.right != null) {

                // find its in-order successor node
                TreeNode inOrderSuccessor = getMin(root.right);

                // Copy the value of successor to current node
                root.data = inOrderSuccessor.data;

                // recursively delete the successor. Note that the
                // successor will have at-most one child (Right child)
                root.right = delete(root.right, inOrderSuccessor.data);
            }

            // Case 3: node to be deleted has only one child
            else {
                root = (root.left != null) ? root.left : root.right;
            }
        }

        return root;
    }

    public static TreeNode insertRecursive(TreeNode root, int key) {

        // if the root is null, create a new node an return it
        if (root == null) {

            return new TreeNode(key);
        }

        // if given key is less than the root node,
        // recur for left subtree
        else if (key < root.data) {
            root.left = insertRecursive(root.left, key);
        }
        // else recur for right subtree
        else if (key > root.data) {
            root.right = insertRecursive(root.right, key);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        int[] keys = {15, 10, 20, 8, 12, 16, 25};

        for (int key : keys) {
            root = insertRecursive(root, key);
        }

        TreeNode.inOrder(root);

        TreeNode newRoot = delete(root, 12);

        System.out.println();
        TreeNode.inOrder(newRoot);

        System.out.println();
        TreeNode secondRoot = delete(newRoot, 10);

        System.out.println();
        TreeNode.inOrder(secondRoot);

    }

}
