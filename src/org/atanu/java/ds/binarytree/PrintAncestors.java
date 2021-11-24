package org.atanu.java.ds.binarytree;

public class PrintAncestors {

    public static boolean printAncestors(TreeNode root, int key) {

        /* base cases */
        if (root == null) {
            return false;
        }

        if (root.val == key) {
            return true;
        }
		
		/* If target is present in either left or right subtree  
        of this node, then print this node */
        if (printAncestors(root.left, key) || printAncestors(root.right, key)) {

            System.out.print(root.val + " ");
            return true;
        }

        return false;
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

        printAncestors(a, 5);

    }

}
