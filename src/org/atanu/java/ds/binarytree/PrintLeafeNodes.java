package org.atanu.java.ds.binarytree;

public class PrintLeafeNodes {

    public static void printLeafeNodes(TreeNode root) {

        // Base Condition
        if (root == null)
            return;

        //print leafe. both left and right nodes are null
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
            return; // No need to recurr
        }

        printLeafeNodes(root.left);

        printLeafeNodes(root.right);
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


        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.left.left = new TreeNode(99);
        root.left.right.left.left.right = new TreeNode(199);
        root.left.right.right = new TreeNode(14);
        root.right = new TreeNode(22);
        root.right.right = new TreeNode(25);

        printLeafeNodes(root);

    }

}
